function getValue(id) {
	return document.getElementById(id).value.trim();
}
function setValue(errId, value) {
	document.getElementById(errId).innerHTML = value;
	document.getElementById(errId).style.color = 'red';
}
function checkValueError(id, length, errId, errStr) {
	if ("" == getValue(id) || length < getValue(id).length) {
		setValue(errId, errStr);
		// 获得焦点
		document.getElementById(id).focus();
		return true;
	} else {
		return false;
	}
}
function isNum(id, start, end) {
	var reg = new RegExp("^\\d{" + start + "," + end + "}$");
	var obj = document.getElementById(id);
	if (!reg.test(obj.value)) {
		return false;
	} else {
		return true;
	}
}

function validateFile(id, errId, dir) {
	var obj = document.getElementById(id);
	var value = obj.value;
	if ("" == value) {
		setValue(errId, "请选择文件后再上传.");
		return false;
	}
	var extend = value.substring(value.lastIndexOf(".") + 1);
	var type = document.getElementById(dir).value;
	if (extend == "") {
		setValue(errId, "选择的文件类型不正确,请重试.");
		return false;
	} else {
		// .jpg/.png/.bmp/.mp3
		if (!(extend == "jpg" || extend == "png" || extend == "bmp" || extend == "mp3")) {
			setValue(errId, "选择的文件类型不正确,请重试.");
			return false;
		} else {
			// .mp3文件类型不匹配(异或运算)
			// .jpg/.png/.bmp类型不匹配问题无需验证,因为都是图片
			if ((extend == "mp3") ^ ("/musicsSrc/" == type)) {
				setValue(errId, "文件格式与选择的文件类型不匹配,请重试.");
				return false;
			} else {
				return true;
			}
		}
	}
}
