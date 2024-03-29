<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board.css" type="text/css" />
<script src="js/ajax.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	let user_id_count = 0;
	let user_id = '';

	const openZipcode = () => {
		new daum.Postcode({
	        oncomplete: function(data) {
	            // console.log(data);
	        	// alert('우편번호: ' + data.zonecode + '\n도로명주소: ' + data.roadAddress);
	            let { zipcode, address1 } = document.regist; // dom의 id가 아닌 name을 가져온다...
	            zipcode.value = data.zonecode;
            	address1.value = data.roadAddress;
	        }
	    }).open();
	};
	
	const validate = () => {
		let f = document.regist;
		
		if (f.user_id.value.length < 3 || f.user_id.value.length > 12) {
			alert('아이디는 3글자 이상 12글자 이하로 작성하세요');
			f.user_id.focus();			
			return;
		}
		 
		if (f.user_name.value.length < 2 || f.user_name.value.length > 6) {
			alert('이름은 2글자 이상 6글자 이하로 작성하세요');
			f.user_name.focus();
			return;
		}
		
		if (f.user_pw.value.length < 4 || f.user_pw.value.length > 20) {
			alert('비밀번호는 4글자 이상 20글자 이하로 작성하세요');
			f.user_pw.focus();
			return;
		}
		
		
		if (f.user_pw.value != f.user_pw2.value) {
			alert('비밀번호/비밀번호 확인이 일치하지 않습니다.');
			f.user_pw.focus();
			return;
		}
		
		
		if (f.user_birth.value == "") {
			alert('생년월일을 입력하세요');
			f.user_birth.focus();
			return;
		}
		
		if (f.user_phone.value == "") {
			alert('연락처를 입력하세요');
			f.user_phone.focus();
			return;
		}
		
		if (f.zipcode.value == "") {
			alert('우편번호를 입력하세요');
			f.btnZipcode.focus();
			return;
		}

		if (f.address1.value == "") {
			alert('주소를 입력하세요');
			f.address1.focus();
			return;
		}

		if (f.address2.value == "") {
			alert('상세주소를 입력하세요');
			f.address2.focus();
			return;
		}

		if (user_id_count != 0) {
			alert('사용할 수 있는 아이디가 아닙니다.');
			return;
		}
		
		f.method = 'POST';
		f.action = 'MemberRegisterAction.do';
		f.submit();
	};
	
	const change_user_id = () => {
		// console.log(document.regist.user_id.value);
		user_id = document.regist.user_id;
		
		if (user_id.value.length < 3 || user_id.value.length > 12) {
			document.getElementById('check_id_result').innerHTML = '아이디는 3글자 이상 12글자 이하로 입력해주세요.';
			// user_id.focus();
			return;
		}
		
		new Request('CheckID.do', 'user_id=' + user_id.value, callback, 'POST');
	};
	
	const callback = (xhr) => {
		if (xhr.readyState == 4 && xhr.status) {
			user_id_count = parseInt(xhr.responseText);
			// alert('user_id_count: ' + user_id_count);
			if (user_id_count == 1){
				document.getElementById('check_id_result').innerHTML = '<font color="red">' + user_id.value + '는 이미 사용중인 아이디 입니다.</font>';
				return;
			} else if (user_id_count == 0) {
				document.getElementById('check_id_result').innerHTML = '<font color="green">' + user_id.value + '는 사용 가능한 아이디 입니다.</font>';
				return;
			} else {
				alert('시스템 오류입니다~!!!!');
			}
		}
	};
</script>
</head>
<body>
<form name="regist" method="post">
<table border="1">
	<caption>회원 가입</caption>
<tr>
	<th>아이디</th>
	<td><input type="text" name="user_id" id="user_id" onkeyup="change_user_id()"/>
		<div id="check_id_result">아이디는 3글자 이상 12글자 이하로 입력해주세요.</div>
	</td>
</tr>
<tr>
	<th>이름</th>
	<td><input type="text" name="user_name" id="user_name" /></td>
</tr>
<tr>
	<th>비밀번호</th>
	<td><input type="password" name="user_pw" id="user_pw" /></td> 
</tr>
<tr>
	<th>비밀번호 확인</th>
	<td><input type="password" name="user_pw2" id="user_pw2" /></td>
</tr>
<tr>
	<th>생일</th>
	<td><input type="date" name="user_birth" id="user_birth" /></td>
</tr>
<tr>
	<th>전화</th>
	<td><input type="text" name="user_phone" id="user_phone" /></td>
</tr>
<tr>
	<th>우편번호</th>
	<td>
		<input type="text" name="zipcode" readonly="readonly"
		onclick="alert('검색버튼을 이용하여 입력하세요');" 
		style="width:55px;"/>
		<input type="button" value="검색" name="btnZipcode"
		onclick="openZipcode()"
		/>
	</td>
</tr>
<tr>
	<th>주소</th>
	<td>
		<input type="text" name="address1" style="width:250px;"/><br/>
	</td>
</tr>
<tr>
	<th>상세 주소</th>
	<td>
		<input type="text" name="address2" /><br/>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="button" value="완료" onclick="validate()" />
	</td>
</tr>
</table>
</form>
</body>
</html>