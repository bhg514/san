#jQuery Instagram Plugin


Get a list of images related to a tag on Instagram

#Example

      <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
      <script src="dist/jquery.instagram-tag.js"></script>

      <script type="text/javascript">
      
        $(document).ready(function(){
    
            var callback = function (images) {
                
                $.each(images, function(i, item) {
                    $('body').append('<img src="'+item.link+'"/>');
                });
            };
    
            $.InstagramPlugin({tag: 'sea', limit: 10, instagram_url: u}, callback);
    
        });
      </script>
    
# Dependencies

### Usage
- jQuery

### Dev
- Ruby

#Development
Capucine : [Official Repo](https://github.com/damln/Capucine)


    gem install capucine
    cd jquery.instagram-tag/
    capucine watch


#Author


- [Damian Le Nouaille](http://dln.name/)
- [Twitter (@damln)](http://twitter.com/damln)