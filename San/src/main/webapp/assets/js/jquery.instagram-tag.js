(function() {

  $.InstagramPlugin = function(method) {
    var methods;
    methods = {
      init: function(options, callback) {
        this.images = [];
        this.settings = $.extend({
          'limit': 15,
          'tag': 'sea',
          'rss_url': '',
          'instagram_url': 'http://instagr.am/tags/TAG_REGEX/feed/recent.rss'
        }, options);
        this.settings.tag = this.settings.tag.replace('#', '');
        this.settings.rss_url = this.settings.instagram_url.replace('TAG_REGEX', this.settings.tag);
        return $.ajax({
          url: "http://query.yahooapis.com/v1/public/yql",
          data: {
            q: "select * from xml where url='" + this.settings.rss_url + "'"
          },
          type: 'GET',
          async: false,
          context: this,
          success: function(xhr) {
            var count, img, img_node, items_obj, obj, self, _i, _len;
            items_obj = $(xhr).find('query channel item');
            self = this;
            count = 1;
            for (_i = 0, _len = items_obj.length; _i < _len; _i++) {
              img_node = items_obj[_i];
              img = $(img_node);
              obj = {
                link: img.find('link').first().text(),
                title: img.find('title').first().text(),
                description: img.find('description').first().text(),
                pubDate: img.find('pubDate').first().text()
              };
              self.images.push(obj);
              if (count === self.settings.limit) {
                break;
              }
              count = count + 1;
            }
            return callback(this.images);
          }
        });
      }
    };
    if (methods[method]) {
      return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
    } else if (typeof method === 'object' || !method) {
      return methods.init.apply(this, arguments);
    } else {
      return $.error('Method ' + method + ' does not exist on $.InstagramPlugin');
    }
  };

}).call(this);
