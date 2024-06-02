$(document).ready(function() {
 
    var showChar = 300;  
    var ellipsestext = "...";
    var moretext = "Ler mais... ";
    var lesstext = "Esconder ..";
    

    $('.more').each(function() {
        var content = $(this).html();
 
        if(content.length > showChar) {
 
            var c = content.substr(0, showChar);
            var h = content.substr(showChar, content.length - showChar);
 
            var html = c + '<span class="moreellipses">' + ellipsestext+ '&nbsp;</span><span class="morecontent"><span>' + h + '</span>&nbsp;&nbsp;<a href="" class="morelink">' + moretext + '</a></span>';
 
            $(this).html(html);
        }
 
    });
 
    $(".morelink").click(function(){
        if($(this).hasClass("less")) {
            $(this).removeClass("less");
            $(this).html(moretext);
        } else {
            $(this).addClass("less");
            $(this).html(lesstext);
        }
        $(this).parent().prev().toggle();
        $(this).prev().toggle();
        return false;
    });
});

                  
// $(function espere(){ 

//   $("#search").keyup(function(){
                  
    
//     var texto = $(this).val();
    
//     $("busca.html #bloco").each(function(){
//       var resultado = $(this).text().toUpperCase().indexOf(' '+texto.toUpperCase());
      
//       if(resultado < 0) {
//         $(this).fadeOut();
//       }else {
//         $(this).fadeIn();
//       }
//     }); 

//   });

// });


// function busca_interna() {
// extensao = "html";
// location.href=document.form.pagina.value+"."+extensao;	
// } 
// var NS4 = (document.layers);
// var IE4 = (document.all);
// var win = this;
// var n   = 0;

// function findInPage(str) {
// var txt, i, found;
// if (str == "")
// return false;
// if (NS4) {
// if (!win.find(str))
// while(win.find(str, false, true))
// n++;
// else
// n++;
// if (n == 0) alert(str + " não foi encontrado nessa página.");
// }
// if (IE4) {
// txt = win.document.body.createTextRange();
// for (i = 0; i <= n && (found = txt.findText(str)) != false; i++) {
// txt.moveStart("character", 1);
// txt.moveEnd("textedit");
// }
// if (found) {
// txt.moveStart("character", -1);
// txt.findText(str);
// txt.select();
// txt.scrollIntoView();
// n++;
// }
// else {
// if (n > 0) {
// n = 0;
// findInPage(str);
// }
// else
// alert(str + " não foi encontrado nessa página.");
// }
// }
// return false;
// }
// var busca = null;
// var array = ["Gui Ferreira Code","Dicas de Programação","Você aprende Praticando"] ;

// $(document).ready(function(){
//   $('#entrada').bind('input',function(){
//     busca = $(this).val().toLowerCase();
    
//     if(busca !== ''){
//       var corresponde = false;
//       var saida = Array();
//       var quantidade = 0;
//       for(var key in array){
        
//         corresponde = array[key].toLowerCase().indexOf(busca) >= 0;
//         if(corresponde){
//           saida.push(array[key]);
//           quantidade += 1;
//         }
//       }
//       if(quantidade){
//         $('#saidaTxt').text('');
//         $('#quantidade').html(quantidade+' resultados!<br><br>');
//         for(var ind in saida){
//            $('#saidaTxt').append("<li>"+saida[ind]+"</li>"+"<br>");
//         }
        
//       }else{
//         $('#quantidade').html('');
//         $('#saidaTxt').text('Nenhum resultado...');
//       }
    
//     }else{
//       $('#quantidade').html('');
//       $('#saidaTxt').text('Nenhum resultado...');
//     }
    
    
    
//   });
// });

// var str;
// $(document).ready(function(){
// $("#search").keyup(function(event){
//    // window.location.href="busca.html";
//     str = $("#search").val();
// 	var er = new RegExp(str,"im");
// 	$("#bloco div").stop().hide(1000);
// 	$("#bloco div").each(function(){
// 		val = $(this).html();
// 		if (er.test(val)){
// 			$(this).stop().show(1000);
// 		}
// 	});
// 	//alert(ids);
// });
// });
// $(document)(function search(){
//     	var str = document.getElementById("search");
//         //window.location.href ="busca.html";
// 		window.location.replace("busca.html?searchQuery.search"+str.value);
// });
// $(document).ready(function(){
// // Pega o ID do formulário e efetua o evento SUBMIT.
// $('#form').live('submit',function(){
//                // Aqui entrarão os valores dos campos, onde pega o ID do campo respectivo e o tamanho do campo.
// 	var nome = $('#cad').attr('value').length;
// 	// Aqui entra a condição, onde será mostrado se foi cadastrado ou se precisa dizitar no mínimo 5 caracteres.
// 	if(nome > 5){

// 		$('#resultado').html('Cadastro efetuado com sucesso.'); 

// 	} else {

// 		alert('Por favor, utilize no mínimo 5 caracteres.');
// 	}
// // Retorna false, o valor do formulário.	
// return false;
// });

// });

// $(function() {
	
//   $('#cadastrar').click(function () {
// 		var desc = $('#cad').val();
      
//       if(desc.length <= 5){
//         alert('são no minimo 5 caracteres');
//       }else{
//         $('#form').submit();
//       }
// 	});


// });
 function validarSenha() {
    /// var str = document.getElementById("cad");
     
   if($('#cad').val().trim().length < 5){
      

      document.getElementById("msgemail").innerHTML="<font color='red'>Email inválido </font>";
	  alert("invalidovalido");

      return false;
   }
 return true;
}
function validarConfirm() {
    /// var str = document.getElementById("cad");
     
   if($('#msgeSen').val().trim().length < 5){
      // document.getElementById("cad").innerHTML = $('#cad').val().validationMessage;

       
     document.getElementById("msgeSen").innerHTML="<font color='red'>minimo 5  caracteres </font>";
     // alert('invalid ...');
     //  window.location.reload();
      return false;
   }
   return true;
}
function validarConUs() {
    /// var str = document.getElementById("cad");
     
   if($('#msgeu').val().trim().length < 5){
      // document.getElementById("cad").innerHTML = $('#cad').val().validationMessage;

       
     document.getElementById("msgeu").innerHTML="<font color='red'>minimo 5  caracteres </font>";
      //alert('invalid ...');
     //  window.location.reload();
      return false;
   }
   return true;
}

function valida_form (){
if(document.getElementById("vx").value == ""){
alert('Por favor, preencha o campo post');
document.getElementById("vx").focus();
return false
}
}
function checa(){ 
    if (document.nome_do_form.campoCPF.value!=""){ 
        document.nome_do_form.submit();    
	}else{
        alert("o campo  não pode ficar vazio");
}}


