
var navbar_content = {
		
		div_selector: '#navbar',
		div_title_selector: '#navbar_title',
		div_content_selector: '#navbar_content',
		refresh_url : 'tag/navbar_ajax',
		toggle_url: 'tag/navbar_toggle',
		tagaction_url: 'tag/tag_action',
		nav_sections: {},
		
		
		
		init_module: function(init_params) {
			if (init_params != null)
			{
				for(p in init_params)
				{
					this[p] = init_params[p];
				}
			}
			var gen_elem = $(this.div_selector);
			gen_elem.draggable({ handle: this.div_selector + " div" + this.div_title_selector });

			var sect_elem = $('<div id="general_title">general</div>').addClass("nav_title").click(this.toggle_nav_section);
			gen_elem.append(sect_elem);
			gen_elem.append($('<div id="general_content" style="display: none;"></div>').addClass("nav_content"));
			
			this.refresh_content('all');
		},
		
		refresh_content: function(section) {
			var parent = this;
			$.getJSON(this.refresh_url, {nav_section: section}, function(data) {
				var elem = $(parent.div_content_selector);
				if (data.nav_refresh_data !== undefined && data.nav_refresh_data['general'] !== undefined)
				{
					navbar_content.refresh_section('#general_content',data.nav_refresh_data['general'], 'href', null);
				}
				if (data.nav_refresh_data !== undefined && data.nav_refresh_data['tagslist'] !== undefined)
				{
					navbar_content.refresh_section('#tagslist_content',data.nav_refresh_data['tagslist'], 'ajax', navbar_content.add_tag);
				}
				if (data.nav_refresh_data !== undefined && data.nav_refresh_data['activetags'] !== undefined)
				{
					navbar_content.refresh_section('#activetags_content',data.nav_refresh_data['activetags'], 'ajax', navbar_content.remove_tag);
				}
				
			});

		},
		
		refresh_section: function(id, data, type, ajax_fct) {	
			var elem_section = $(id);
			if (elem_section.length != 1)
				return;
			if (data.fill !== undefined)
			{
				elem_section.empty();
				var liens = data.fill;
				var l = liens.length;
				if (type == 'href')
				{
					for (var n = 0; n < l; n++)
					{
						elem_section.append($('<a href="' + liens[n][1] + '">' + liens[n][0] + '</a><br />'));
					}
				}
				else if (type == 'ajax')
				{
					var params_ajax = {link_function: ajax_fct, link_class: 'nav_ajax_link'};
					for (var n = 0; n < l; n++)
					{
						params_ajax['link_label'] = liens[n][0];
						params_ajax['link_id'] = 'add_tag_' + liens[n][1];
						//elem_section.append($('<span id="' + id + '_' + liens[n][1] + '">' + liens[n][0] + '</span><br />'));
						elem_section.append(cms_utils.generate_ajax_link(params_ajax));
					}
				
				}
				
			}
			if (data.effect !== undefined)
			{
				if (data.effect == 'show' && elem_section.css('display') =='none')
				{
					elem_section.show('blind', {}, 500);
				}
				else if (data.effect == 'hide' && elem_section.css('display') != 'none')
				{
					elem_section.hide('blind', {}, 500);
				}
			}
		},
		
		add_tag: function(){
			var elem = $(this);
			var idtag = elem.attr('id').substring(8);
			$.getJSON(navbar_content.tagaction_url, {nav_action: 'add_tag', nav_action_id: idtag}, function(data) {
				//navbar_content.refresh_content('activetags')
				elem.unbind('click');
				elem.click(navbar_content.remove_tag);
				$('div#activetags_content').append(elem);
				image_gallery.refresh_content();
			});
		},
		
		
		remove_tag: function(){
			var elem = $(this);
			var idtag = elem.attr('id').substring(8);
			$.getJSON(navbar_content.tagaction_url, {nav_action: 'remove_tag', nav_action_id: idtag}, function(data) {
				//navbar_content.refresh_content('activetags')
				elem.unbind('click');
				elem.click(navbar_content.add_tag);
				$('div#tagslist_content').append(elem);
				image_gallery.refresh_content();
			});
		},
		/*
		refresh_content: function() {
			var parent = this; 
			$.get(this.refresh_url, function(data) {
				   var elem = $(parent.div_content_selector);
				   elem.empty();
				   elem.append(data);
				   
				   $('.nav_title').click(parent.toggle_nav_section);
			   })
		},*/
		
		toggle_nav_section: function() {
			elem = $(this).next();
			
			var e_disp = elem.css('display');
			var e_id = elem.attr('id');
			elem.slideToggle('fast');
			$.getJSON(navbar_content.toggle_url, {navSelect: e_id, navState: e_disp}, function(data) {
			});
		}
		
		
}

