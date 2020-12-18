$(function(){
	$("form :input").blur(function(){
		if($(this).is("#username")){      
			if($(this).val() == ""){       
				$("#user").text("请填写用户名");
			}else if(this.value.length>10){
				$("#user").text("用户名过长");
			}else{
				$("#user").text("用户名格式正确");
				$("#user").attr("style","color:green;");
			}
		}
		if($(this).is("#password")){            
			if($(this).val() == ""){        
				$("#pwd").text("请填写密码");
			}else if(this.value.length >10){      
				$("#pwd").text("密码过长");;
			}else{
				$("#pwd").text("密码格式正确");
				$("#pwd").attr("style","color:green;");
			}
		}
	})
})
