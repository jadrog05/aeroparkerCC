function validateEmail(){
    var re = /\S+@\S+\.\S+/;
    let email = document.getElementById("email").value;
    if (re.test(email) && (email.length < 255)) {
        document.getElementById("email").style.background ="#e0fde0";
        return true;
    } else {
        document.getElementById("email").style.background ="#ffdddc";
        return false;
    }
}

function validatePhone(){
    let element = document.getElementById("phone");
    let value = element.value;
    let re = /^[0-9]+$/;
    if (re.test(value) && value.length < 20 ){
        document.getElementById("phone").style.background ="#e0fde0";
        return true;
    } else {
        document.getElementById("phone").style.background ="#ffdddc";
        return false;
    }
}

function validateString(x,chars){
    let element = document.getElementById(x);
    let value = element.value;
    console.log(value.toString);
    if (value.length == 0 || value.length > chars ){
        element.style.background ="#ffdddc";
        return false;
    } else {
        element.style.background ="#e0fde0";
        return true;
    }
}

function validateStringNullAllowed(x,chars){
    let element = document.getElementById(x);
    let value = element.value;
    console.log(value.toString);
    if (value.length > x ){
        element.style.background ="#ffdddc";
        return false;
    } else {
        element.style.background ="#e0fde0";
        return true;
    }
}

function validateForm(){
    var result = true;
    let email = validateEmail();
    let phone = validatePhone();
    let title = validateString("title",5);
    let fName = validateString("first_name",50);
    let lName = validateString('last_name',50);
    let aL1 = validateString('address_line_1',255);
    let aL2 = validateStringNullAllowed('address_line_2',255);
    let city = validateStringNullAllowed('city',255);
    let postcode = validateString('postcode',10);
    var boolArray = [email,phone,title,fName,lName,aL1,aL2,city,postcode];
    for (let i = 0; i < boolArray.length; i++){
        if(boolArray[i] == false){
            result =  false;
        }
    }
    return result;
}

function emailUsedAlert(isUsed){
    if (isUsed == true){
        alert("That email has been used before!");
    }
}

