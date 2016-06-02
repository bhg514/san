<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html class="no-js" dir="ltr" lang="en" xmlns="http://www.w3.org/1999/xhtml" xmlns:og="http://ogp.me/ns#" xmlns:fb="http://www.facebook.com/2008/fbml">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>jQuery Instagram</title>

  <meta name="description" content="">
  <meta name="author" content="Damian Le Nouaille">
</head>

<body class="home_view">
<div id="page_wrap" class="wrap">
</div>

  <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
  <script src="dist/jquery.instagram-tag.js"></script>

  <script type="text/javascript">
    $(document).ready(function(){

        var callback = function (images) {

            $.each(images, function(i, item) {
                $('body').append('<img src="'+item.link+'"/>');
            });
        };

        $.InstagramPlugin({tag: 'sea', limit: 10}, callback);

        // OR : use custom URL for API changes
        // var u = "http://instagr.am/tags/example/new/url/blala/TAG_REGEX/feed/recent.rss";
        // $.InstagramPlugin({tag: 'sea', limit: 10, instagram_url: u}, callback);

    });
  </script>

</body>
</html>