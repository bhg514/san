   var scroll_start = 0;
  
   $(document).scroll(function() { 
      scroll_start = $(this).scrollTop();
      console.log(scroll_start);
      if(scroll_start > 700) {
          $('.navbar-inverse').css('background-color', 'rgba(10,10,10,0.3)');
       } else {
          $('.navbar-inverse').css('background-color', 'transparent');
       }
   });

   
   var angle = 0;
   function galleryspin(sign) { 
   spinner = document.querySelector("#spinner");
   if (!sign) { angle = angle + 45; } else { angle = angle - 45; }
   spinner.setAttribute("style","-webkit-transform: rotateY("+ angle +"deg); -moz-transform: rotateY("+ angle +"deg); transform: rotateY("+ angle +"deg);");
   }
   
   