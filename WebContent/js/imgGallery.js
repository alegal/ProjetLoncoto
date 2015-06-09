
var image_gallery = {
	
	div_selector: '#gallery',
	div_content_selector: '#gallery-content',
	div_title: '#gal_title',
	div_navigation: '#gal_nav_page',
	refresh_url : 'image/liste_ajax',
	page_index: 0,
	page_count: 1,
	active_tags: [],
	
	
	
	init_module: function(init_params) {
		if (init_params != null)
		{
			for(p in init_params)
			{
				this[p] = init_params[p];
			}
		}
		/*this.active_tags[0] = 1;
		this.active_tags[1] = 2;
		*/
		$('body').keydown(image_gallery.key_nav_page);
		var elem_div = $(this.div_selector);
		var elem_handle = $(this.div_selector + ' ' + this.div_title);
		elem_div.draggable({handle: elem_handle});
		this.refresh_content();
	
	},

	serialize_tags: function() {
		var result = "";
		$.each(this.active_tags, function(index, item) {
			if (index == 0)
				result += item;
			else
				result += ',' + item;	
		});
		return result;
	},
	
	unserialize_tags: function(chaine) {
		return chaine.split(',');
	},
	
	
	refresh_content: function() {
		var selec = this.div_content_selector;
		var ser_tag = this.serialize_tags();
		$.getJSON(this.refresh_url, {page_index: this.page_index, stringNavTags: ser_tag}, function(data) {
			image_gallery.page_count = data.page_count;
			var elem = $(selec);
			elem.empty();
			var link_params = {link_type: 'thumb_classic', link_class: 'thumbimg' };
			$.each(data.images_id, function(index, item) {
				link_params['link_id']='timg_' + item;
				link_params['link_url']='image/show?imageID=' + item;
				link_params['link_image']='image/thumbdata?imageID=' + item;
				var newelem = cms_utils.generate_ajax_link(link_params);
				elem.append(newelem);
			});
			var newelembottom = $('<div><span>gallerie image page '+ (image_gallery.page_index + 1) +'/'+ image_gallery.page_count +' </span></div>').addClass('gallery_page_nav');
			var newelemnav = $('<button id="first-page">premiere page </button>').button({
				text: false,
				icons: {
					primary: 'ui-icon-arrowthickstop-1-w'
				}
			}).click(image_gallery.go_first_page);
			
			newelembottom.append(newelemnav);
//			newelembottom.append($('<span> - </span>'));
			if (image_gallery.page_index > 0)
			{
				newelemnav = $('<button id="previous-page">page precedente</button>').button({
					text: false,
					icons: {
						primary: 'ui-icon-arrowthick-1-w'
					}
				}).click(image_gallery.go_previous_page);
				newelembottom.append(newelemnav);
			}
			if (image_gallery.page_index < image_gallery.page_count - 1)
			{
				newelemnav = $('<button id="next-page">page suivante</button>').button({
					text: false,
					icons: {
						primary: 'ui-icon-arrowthick-1-e'
					}
				}).click(image_gallery.go_next_page);
				newelembottom.append(newelemnav);
			}
			var newelemnav = $('<button id="last-page">derniere page</button>').button({
				text: false,
				icons: {
					primary: 'ui-icon-arrowthickstop-1-e'
				}
			}).click(image_gallery.go_last_page);
			
			newelembottom.append(newelemnav);
			
			var elem = $(image_gallery.div_selector + ' ' + image_gallery.div_title);
			//elem = $('div#gal_nav_page');
			elem.empty();
			elem.append(newelembottom);
			
			
		});
		/*$.get(this.refresh_url, function(data) {
			   var elem = $(selec);
			   elem.empty();
			   elem.append(data);
		   })*/
	},
	
	go_next_page: function() {
		
		image_gallery.page_index += 1;
		image_gallery.refresh_content();
	},

	go_previous_page: function() {
		if (image_gallery.page_index > 0)
			image_gallery.page_index -= 1;
		image_gallery.refresh_content();
	},
	
	go_first_page: function() {
		image_gallery.page_index = 0;
		image_gallery.refresh_content();
	},

	go_last_page: function() {
		image_gallery.page_index = image_gallery.page_count - 1;
		image_gallery.refresh_content();
	},

	key_nav_page: function(e) {
		if (e.which == 37 && image_gallery.page_index > 0)
		{
			image_gallery.go_previous_page();
			return false;
		}
		if (e.which == 39 && image_gallery.page_index < image_gallery.page_count - 1)
		{
			image_gallery.go_next_page();
			return false;
		}
		return;
	}
	
};
