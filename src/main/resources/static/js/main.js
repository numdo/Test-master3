document.addEventListener('DOMContentLoaded', function(){


    // VISUAL SLIDER
    var visualSlider = new Swiper('.visual-slider', { 
		effect:'fade',
		autoplay:true,
		speed : 1000,
		loop:true,
        pagination: {
            el: '.visual-slider .swiper-pagination',
            type: 'fraction',
        },
        navigation: {
            nextEl: '.visual-slider .swiper-button-next',
            prevEl: '.visual-slider .swiper-button-prev',
        },
    });
    visualSlider.autoplay.play();

   





  
});




$(function(){

 
   
    
    // 알림판 슬라이드
    $("#popList").slick({
        slidesToShow: 4,
        slidesToScroll: 1,
	    speed: 2000,
        autoplay: true
	  
    });      
    $('.popup .control a').click(function(e){
        e.preventDefault();
        $this = $(this);
        slickControl( $this, '#popList', '#popupStop', '#popupPlay');
    });	
    
   

    
});
// slick control
function slickControl($this, slick, stop, play){
    $slick = $(slick); //slider wrap
    $stop = $(stop); //Stop Button
    $play = $(play);//Play Button

    if($this.is(stop)){
        $stop.css('display','none');
        $play.delay(100).css('display','block');
        $slick.slick('slickPause');
    }
    if($this.is(play)){
        $play.css('display','none');
        $stop.delay(100).css('display','block');
        $slick.slick('slickPlay');
    }
};




