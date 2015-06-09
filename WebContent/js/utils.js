var cms_utils = {
		
	generate_ajax_link : function (link_params) {
		var local_params = {
				link_type: 'span',
				new_line: true,
				link_class: 'ajax_link',
				link_function: function (){return false;},
				link_url: '/',
				link_image: '/',
				link_label: 'lien ajax',
				link_id: 'ajxid'
				
		};
		if (link_params != null)
		{
			for(p in link_params)
			{
				local_params[p] = link_params[p];
			}
		}
		var elem;
		if (local_params.link_type == 'span')
		{
			if (local_params.new_line)
				elem = $('<span id="' + local_params.link_id + '">' + local_params.link_label + '<br /></a>').addClass(local_params.link_class).click(local_params.link_function);
			else
				elem = $('<span id="' + local_params.link_id + '">' + local_params.link_label + '</a>').addClass(local_params.link_class).click(local_params.link_function);
			return elem;
		}
		if (local_params.link_type == 'thumb_classic')
		{
			elem = $('<div id="' + local_params.link_id + '"><a href="' + local_params.link_url + '"><img src="' + local_params.link_image + '"/></a></div>').addClass(local_params.link_class);
			return elem;
		}
		return elem;
	}
		
};