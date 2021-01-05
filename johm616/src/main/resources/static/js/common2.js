




jQuery(function($) {
    $('input.inputNumberText').numeric();
});

function inputNumberTextKeyDown(){
    var event = window.event;
    
    if (event.keyCode != 13) {
        if (event.keyCode != 8) {
            if (event.keyCode == 9 || (event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105)) {
            }else{
                event.returnValue = false;
            }
        }
    }
}

function isEmpty(value) {
    return (value == null || value == undefined || value == "");
}

function openWindow(url, width, height, target) {
    if (isEmpty(target)) {
        target = '_BLANK';
    }
    
    window.open(url, target, 'width=' + width + ',height=' + height + ',scrollbars=yes');    
}


function discountPrice(sellPrice, dscntRate){
    
    var rate = parseFloat(dscntRate);
    var discountRate = (rate * 100.0) / 100.0;
    var minusPrice = Number((sellPrice * (discountRate / 100)));
    minusPrice = cutoff(minusPrice);
    
    return minusPrice;
}

function cutoff(minusPrice){
    return parseInt(Math.round((parseFloat(minusPrice) / 100.0))) * 100;
}

function expectSavePoint(sellPrice, dscntRate){
    
    var savePoint = (sellPrice * dscntRate) / 1000.0;
    savePoint = Math.floor(parseFloat(savePoint)) * 10;
    return parseInt(savePoint);
}



function discountRate(sellPrice, dscntSellPrice){

    var newDiscountRate = ((parseInt(sellPrice) - parseInt(dscntSellPrice)) / (parseInt(sellPrice) * 1.0)) * 100.0;
    newDiscountRate = Math.ceil(newDiscountRate);
    
    return newDiscountRate;
}

function price_format(val){
    val = $.trim(val+"");
    if(val == ''){ return val; }
    if(isNaN(val)){ return val; }

    var rv = "", idx = 0;
    for (var i = val.length-1 ; i >= 0 ; i--){
        rv = ((idx != 0 && idx%3 == 0) ? val.substring(i, i+1) + "," : val.substring(i, i+1)) + rv;
        idx++;
    }

    return rv;
}

function onlyNum() {
	if(((event.keyCode < 48) || (event.keyCode > 57))
            && event.keyCode != 8 && event.keyCode != 9
            && ((event.keyCode < 96) || (event.keyCode > 105))
            && event.keyCode != 46 && event.keyCode != 13
            && event.keyCode != 37 && event.keyCode != 39
            && event.keyCode != 35 && event.keyCode != 36){
		event.returnValue = false;
	}
}

function onlyNumForKeyup(obj) {
    var isValid = false;
    var pattern = /\D/g;
    var cut = obj.val().substr(0, obj.val().length - 1);
    
    if (pattern.test(obj.val())) {
        isValid = false;
        alert("숫자만 사용할 수 있습니다.");
        obj.val(cut);
    } else {
        isValid = true;
    }
    
    return isValid;
}


function dataFormat(str){
	if(str.length == 8){
		str = str.substr(0,4) + "-" + str.substr(4,2) + "-" + str.substr(6,2);
	}

	return str;
}

function validateResno(obj) {
    return onlyNumForKeyup(obj);
}

function validatePassword(obj) {
    var isValid = false;

    if (!isEmpty(obj.val()) && (obj.val().length < 4)) {
        isValid = false;
        obj.next().text("영문, 숫자, 특수문자 조합해서 4자 이상 입력").css("color", "gray");
    } else if (obj.val().length >= 4) {
        var pattern1 = /\s/g;
        var pattern2 = /\D/g;
        var cut = obj.val().substr(0, obj.val().length - 1);
        
        if (pattern1.test(obj.val())){
            isValid = false;
            alert("공백은 입력할 수 없습니다.");
            obj.val(cut);
        }
        
        if (pattern2.test(obj.val())){
            isValid = true;
            obj.next().text("사용가능.").css("color", "#00bff3");
            
            var alpNum = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"];
            var spc = ["`", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "=", "+", "[", "{", "]", "}", "\\", "|", "'", "\"", ";", ":", "/", "?", ".", ">", ",", "<"];
            
            for (var i = 0; i < alpNum.length; i++) {
                var pattern3 = new RegExp(alpNum[i] + "{3,}", "g");
                if (pattern3.test(obj.val())){
                    isValid = false;
                    obj.next().text("같은 문자를 세번이상 사용할 수 없습니다.").css("color", "#fe5156");
                    break;
                }
            }
            
            for (var j = 0; j < spc.length; j++) {
                var pattern4 = new RegExp("\\" + spc[j] + "{3,}", "g");
                if(pattern4.test(obj.val())){
                    isValid = false;
                    obj.next().text("같은 문자를 세번이상 사용할 수 없습니다.").css("color", "#fe5156");
                    break;
                }
            }
        } else {
            isValid = false;
            obj.next().text("숫자만 사용할 수 없습니다.").css("color", "#fe5156");
        }
    } else {
        isValid = false;
        obj.next().text("영문, 숫자, 특수문자 조합 4~12자").css("color", "gray");
    }
    
    return isValid;
}

function validateNumPassword(obj) {
    var isValid = false;
    
    if (!isEmpty(obj.val()) && (obj.val().length < 4)) {
        isValid = false;
        obj.next().text("4자리 숫자").css("color", "gray");
    } else if (obj.val().length == 4) {
        var num = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"];
        var pattern = /\D/g;
        
        if (pattern.test(obj.val())) {
            isValid = false;
            obj.next().text("숫자만 사용할 수 있습니다.").css("color", "#fe5156");
        } else {
            isValid = true;
            obj.next().text("사용가능.").css("color", "#00bff3");
        }
        
        for (var i = 0; i < num.length; i++) {
            var pattern3 = new RegExp(num[i] + "{4,}", "g");
            if (pattern3.test(obj.val())){
                isValid = false;
                obj.next().text("같은 숫자를 네번 사용할 수 없습니다.").css("color", "#fe5156");
                break;
            }
        }
    }
    
    return isValid;
}

function imageError(obj) {
    obj.src = "//image.crewmate.co.kr/demoshop/noimage.gif";
}

function validateId(obj) {
    var pattern = /\W/g;
    var cut = obj.val().substr(0, obj.val().length - 1);
    
    if (!isEmpty(obj.val()) && pattern.test(obj.val())){
        alert("영문, 숫자만 입력할 수 있습니다.");
        obj.val(cut);
    }
}

function validateName(obj) {
    var pattern = /[^ㄱ-힣]/g;
    var cut = obj.val().substr(0, obj.val().length - 1);
    
    if (!isEmpty(obj.val()) && pattern.test(obj.val())){
        alert("한글만 입력할 수 있습니다.");
        obj.val(cut);
    }
}

/*****
* 영문과 숫자만 입력
* onkeydown="javaScript:validateNonKr();"
******/
function validateNonKr() {
	
	if(event.keyCode == 13 || event.keyCode == 35 || event.keyCode == 36 || event.keyCode == 37 || event.keyCode == 39 || event.keyCode == 116 || event.keyCode == 8 || event.keyCode == 16 || (65 <= event.keyCode && event.keyCode <= 90) || (event.keyCode >= 96 && event.keyCode <= 105) || (!event.shiftKey && (47 < event.keyCode && event.keyCode < 58))){
	}else{
		event.returnValue = false;
	}
}

/*****
* 영문과 숫자 골뱅이@ 쩜. 만입력
* onkeydown="javaScript:validateNonKrForEmail();"
******/
function validateNonKrForEmail() {
	if(event.keyCode == 13 || event.keyCode == 35 || event.keyCode == 36 || event.keyCode == 37 || event.keyCode == 39 || event.keyCode == 50 || event.keyCode == 110 || event.keyCode == 116 || event.keyCode == 190 || event.keyCode == 8 || event.keyCode == 16 || (65 <= event.keyCode && event.keyCode <= 90) || (event.keyCode >= 96 && event.keyCode <= 105) || (!event.shiftKey && (47 < event.keyCode && event.keyCode < 58) || (event.shiftKey && event.keyCode === 189) || event.keyCode == 189)){
	}else{
		return false;
	}
}

/*****
* 111@222.333.444
* @ 로 split한후 111 에 영문과숫자 - _ 를 제외한 특수문자를 체크한다.
* @ 로 split한후 도메인에 영문과 숫자 - _ 를 제외한 특수문제를 체크하고  222.333 형태인지 체크한다.
******/
function validateEmail(temp) {
    var tempArray = temp.split("@",2);
    var flag = true;
	    if(tempArray[0] == null || (/[^\w-]/g).test(tempArray[0]) || tempArray[1] == null || (/[^\w\.]/g).test(tempArray[1]) || !(/[^\s\.]\.[^\s\.]/g).test(tempArray[1])){
	    	flag = false;
	    }
	    return flag;
}

/*****
* 숫자와 ,   입력 (전화번호)
* onkeydown="javaScript:validateSmsPhoneNumber();"
******/
function validateSmsPhoneNumber() {
	
	if(event.keyCode == 8 || 35 <= event.keyCode && event.keyCode <= 40 || event.keyCode == 46 || event.keyCode == 188 || (48 <= event.keyCode && event.keyCode <= 57) || (96 <= event.keyCode && event.keyCode <= 105) || (!event.shiftKey && (47 < event.keyCode && event.keyCode < 58))){
	}else{
		event.returnValue = false;
	}
}

/*****
 * 이메일 입력
 * onkeydown="onlyEmail(this);" onblur="onlyEmail(this);"
******/
function onlyEmail(objtext1) {
    var inText = $(objtext1).val();
    var deny_pattern = /^[a-z|A-Z|0-9|\@\|\.\|\_\|\-\|\*]+$/;
    if (!deny_pattern.test(inText)) {
        inText = inText.replace(/[^a-z|A-Z|0-9|\@|\.|\_|\-|]/gi, '');
        $(objtext1).val(inText);
        return false;
    }
    return true;
}

/*****
 * 숫자만 입력
 * onkeydown="onlyNum(this);" onblur="onlyNum(this);"
******/
function onlyNum(objtext1) {
	var inText = $(objtext1).val();
	var deny_pattern = /^[0-9|\*]+$/;
	if (!deny_pattern.test(inText)) {
		inText = inText.replace(/[^0-9]/gi, '');
		$(objtext1).val(inText);
	    return false;
	}
	return true;
}
	
/*****
 * 숫자와  -만  입력
 * onkeydown="onlyNumHyphen(this);" onblur="onlyNumHyphen(this);"
******/
function onlyNumHyphen(objtext1) {
	var inText = $(objtext1).val();
	var deny_pattern = /^[0-9|\-\*]+$/;
	if (!deny_pattern.test(inText)) {
		inText = inText.replace(/[^0-9|\-]/gi, '');
		$(objtext1).val(inText);
		return false;
	}
	return true;
}	
	
