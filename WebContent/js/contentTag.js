var contenttag_choice = {

	div_related_selector: '#selectedtags',
	div_unrelated_selector: '#taglist',
	refresh_related_url : 'tag/relatedlist_ajax',
	refresh_unrelated_url : 'tag/notrelatedlist_ajax',
	add_tag_content_url: 'tag/addtag_ajax',
	remove_tag_content_url: 'tag/removetag_ajax', 
	related_tag_array: [],
	unrelated_tag_array: [],
	content_id: 0,
	
	init_module: function(init_params) {
		if (init_params != null)
		{
			for(p in init_params)
			{
				this[p] = init_params[p];
			}
		}
		this.refresh_content();
	
	},
	
	refresh_content: function() {				
		
		$.getJSON(this.refresh_related_url, {cid: this.content_id}, function(data) {
			var elem = $(contenttag_choice.div_related_selector);
			elem.empty();
			var ajax_params = {link_function: contenttag_choice.remove_tag_from_content, link_class: 'tag_content_ajax' };
			$.each(data.tags, function (index, item) {
				ajax_params['link_id'] = 'ctc_tal' + item.ID;
				ajax_params['link_label'] = item.nom;
				var newelem = cms_utils.generate_ajax_link(ajax_params);
				elem.append(newelem);
			});
		});
		
		$.getJSON(this.refresh_unrelated_url, {cid: this.content_id}, function(data) {
			var elem = $(contenttag_choice.div_unrelated_selector);
			elem.empty();
			var ajax_params = {link_function: contenttag_choice.add_tag_to_content, link_class: 'tag_content_ajax' };
			$.each(data.tags, function (index, item) {
				ajax_params['link_id'] = 'ctc_tal' + item.ID;
				ajax_params['link_label'] = item.nom;
				var newelem = cms_utils.generate_ajax_link(ajax_params);
				elem.append(newelem);
			});
		});
	},
	
	add_tag_to_content: function()
	{
		var elem = $(this);
		elem.unbind('click');
		elem.click(contenttag_choice.remove_tag_from_content);
		$(contenttag_choice.div_related_selector).append(elem);
		var tid = elem.attr('id').substring(7);
		$.getJSON(contenttag_choice.add_tag_content_url, {cid: contenttag_choice.content_id, tagid: tid }, function(data) {
			
		});
		return false;
	},
	
	remove_tag_from_content: function()
	{
		elem = $(this);
		elem.unbind('click');
		elem.click(contenttag_choice.add_tag_to_content);
		$(contenttag_choice.div_unrelated_selector).append(elem);
		var tid = elem.attr('id').substring(7);
		$.getJSON(contenttag_choice.remove_tag_content_url, {cid: contenttag_choice.content_id, tagid: tid }, function(data) {
			
		});
		return false;
	}
}
