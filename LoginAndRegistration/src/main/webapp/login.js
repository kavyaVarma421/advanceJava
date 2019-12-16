 function checkForm(form)
  {
	 var fname = document.getElementById("fname").value;
	 var username = document.getElementById("uname").value;
	 onclick
	 if(fname==""){
		 alert("Error: Username cannot be blank!");
		 return false;
	 }
    if(username == "") {
     // alert("Error: Username cannot be blank!");
		      document.getElementById("user").innerHTML = "Error: Username cannot be blank!";
      //form.username.focus();
      return false;
    }
  }
  function validatePassword()
  {
	  alert('validate password...')
	  var str = document.getElementById("passw").value;
	  //allow only letters and numbers
	  var illegalChars = /[\W_]/;
	  if(str==""){
		  alert("you didn't enter a password..\n");
		  str.style.background = 'red';
		  return false;
	  } else if ((str.length <= 6) || (str.length >= 15)) {
	        alert("The password length is minimum 6 characters and maximum 15 characters..\n");
	        return false;
	  }
	  
  }
      
      