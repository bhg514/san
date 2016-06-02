$.InstagramPlugin = ( method ) ->
  methods =
    init: ( options, callback ) ->
      @images = []

      @settings = $.extend({
        'limit': 15
        'tag'         : 'sea',
        'rss_url': '',
        'instagram_url': 'http://instagr.am/tags/TAG_REGEX/feed/recent.rss',
      },
      options)

      @settings.tag = @settings.tag.replace('#', '')
      @settings.rss_url = @settings.instagram_url.replace('TAG_REGEX', @settings.tag)

      $.ajax({
        url: "http://query.yahooapis.com/v1/public/yql"
        data: {q: "select * from xml where url='"+this.settings.rss_url+"'"}
        type: 'GET'
        async: false
        context: @
        success: (xhr) ->
          items_obj = $(xhr).find('query channel item')

          self = @
          count = 1

          for img_node in items_obj
            img = $(img_node)

            obj =
              link: img.find('link').first().text()
              title: img.find('title').first().text()
              description: img.find('description').first().text()
              pubDate: img.find('pubDate').first().text()
              # media_credit: img.find('media\\:credit').first().text() # TODO

            self.images.push(obj)
            break if count is self.settings.limit
            count = count + 1

          callback(@images)
      })


  if methods[method]
    return methods[method].apply( @, Array.prototype.slice.call( arguments, 1 ))
  else if (typeof method is 'object' || ! method)
    return methods.init.apply( @, arguments )
  else
    $.error( 'Method ' +  method + ' does not exist on $.InstagramPlugin' )