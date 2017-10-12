<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	request.setAttribute("ctx", request.getContextPath());
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="${ctx}/js/validator/style/validator.css"></link>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/validator/formValidator.js"
	type="text/javascript" charset="UTF-8"></script>
<script src="${ctx}/js/validator/formValidatorRegex.js"
	type="text/javascript" charset="UTF-8"></script>
<script src="${ctx}/js/jBox/jquery.jBox-2.3.min.js"
	type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$.formValidator.initConfig({
			formid : "registerForm",
			onerror : function(msg) {
			},
			onsuccess : function() {
				top.jBox.tip("正在注册！", 'loading');
				return true;
			}
		});
		//用户名
		$("#loginName").formValidator({
			onshow : "请输入用户名",
			onfocus : "6-20位字母、数字、下划线组成",
			oncorrect : "该用户名可以注册"
		}).inputValidator({
			min : 6,
			max : 20,
			onerror : "用户名长度不满足要求"
		}).regexValidator({
			regexp : "username",
			datatype : "enum",
			onerror : "用户名格式不正确"
		}).ajaxValidator({
			type : "post",
			url : "${ctx}/register/checkLoginName.shtml",
			data : {
				"loginName" : function() {
					return $("#loginName").val();
				}
			},
			success : function(data) {
				if (data == "1") {
					return true;
				} else {
					return false;
				}
			},
			buttons : $("#button"),
			error : function() {
				alert("服务器没有返回数据，可能服务器忙，请重试");
			},
			onerror : "此用户名已被注册",
			onwait : "正在对用户名进行合法性校验，请稍候..."
		});
		//手机号
		$("#telnum").formValidator({
			onshow : "请输入手机号",
			onfocus : "输入的手机号必须合法",
			oncorrect : "该手机号可以注册"
		}).inputValidator({
			min : 11,
			max : 11,
			onerror : "手机号码必须是11位的哦"
		}).regexValidator({
			regexp : "mobile",
			datatype : "enum",
			onerror : "手机号格式不正确"
		}).ajaxValidator({
			type : "post",
			url : "${ctx}/register/checkPhone.shtml",
			data : {
				"telnum" : function() {
					return $("#telnum").val();
				}
			},
			success : function(data) {
				if (data == "1") {
					return true;
				} else {
					return false;
				}
			},
			buttons : $("#button"),
			error : function() {
				alert("服务器没有返回数据，可能服务器忙，请重试");
			},
			onerror : "此手机号已被注册",
			onwait : "正在对手机号进行合法性校验，请稍候..."
		});

		//邮箱
		$("#email").formValidator({
			onshow : "请输入邮箱",
			onfocus : "此邮箱用来找回密码",
			oncorrect : "该邮箱可以注册"
		}).regexValidator({
			regexp : "email",
			datatype : "enum",
			onerror : "邮箱格式不正确"
		}).ajaxValidator({
			type : "post",
			url : "${ctx}/register/checkEmail.shtml",
			data : {
				"email" : function() {
					return $("#email").val();
				}
			},
			success : function(data) {
				if (data == "1") {
					return true;
				} else {
					return false;
				}
			},
			buttons : $("#button"),
			error : function() {
				alert("服务器没有返回数据，可能服务器忙，请重试");
			},
			onerror : "此邮箱已被注册",
			onwait : "正在对邮箱进行合法性校验，请稍候..."
		});

		//密码

		$("#password1").formValidator({
			onshow : "请输入密码",
			onfocus : "密码必须为6位以上哦",
			oncorrect : "密码合法"
		}).inputValidator({
			min : 6,
			empty : {
				leftempty : false,
				rightempty : false,
				emptyerror : "密码两边不能有空符号"
			},
			onerror : "密码不能为空,请确认"
		});/* .regexValidator({regexp:"password",datatype:"enum",onerror:"密码最少长度为 6位 ，并至少包含2种复杂类别的字符"}); */
		$("#password2").formValidator({
			onshow : "请输入确认密码",
			onfocus : "两次密码必须一致哦",
			oncorrect : "密码一致"
		}).inputValidator({
			min : 1,
			empty : {
				leftempty : false,
				rightempty : false,
				emptyerror : "重复密码两边不能有空符号"
			},
			onerror : "重复密码不能为空,请确认"
		}).compareValidator({
			desid : "password1",
			operateor : "=",
			onerror : "2次密码不一致,请确认"
		});

		//企业名称
		$("#companyname").formValidator({
			onshow : "请输入企业名称",
			onfocus : "请输入企业名称",
			oncorrect : "该企业名可以注册"
		}).inputValidator({
			min : 6,
			onerror : "企业名称长度不满足要求"
		}).ajaxValidator({
			type : "post",
			url : "${ctx}/register/checkCompanyname.shtml",
			data : {
				"companyname" : function() {
					return $("#companyname").val();
				}
			},
			success : function(data) {
				if (data == "1") {
					return true;
				} else {
					return false;
				}
			},
			buttons : $("#button"),
			error : function() {
				alert("服务器没有返回数据，可能服务器忙，请重试");
			},
			onerror : "该企业已被注册过",
			onwait : "正在对企业名进行合法性校验，请稍候..."
		});
		//qq
		$("#qq").formValidator({
			onshow : "请输入qq号码",
			onfocus : "请输入qq号码",
			oncorrect : "qq号码有效"
		}).inputValidator({
			min : 6,
			onerror : "qq号码长度不满足要求"
		}).regexValidator({
			regexp : "qq",
			datatype : "enum",
			onerror : "qq号码格式不正确"
		});

		//汽配商联系人
		$("#username").formValidator({
			onshow : "请输入汽配商联系人",
			onfocus : "请输入汽配商联系人",
			oncorrect : "格式正确"
		}).inputValidator({
			min : 2,
			onerror : "不能少于2个字符"
		});
	});
</script>
<title>修配连汽配市场</title>
<style>
.manage_mode1 {
	display: none;
}

.manage_mode2 {
	display: none;
}

.manage_mode3 {
	display: none;
}

.manage_mode4 {
	display: none;
}

.tt_btn {
	cursor: pointer;
}

.city-area {
	width: 115px;
	padding-left: 5px;
	height: 40px;
	font-size: 14px;
	font-family: '微软雅黑';
	color: #494848;
	border: 1px solid #cdcdcd;
	float: left;
	margin-right: 13px;
	display: inline-block;
}
</style>
<script type="text/javascript">
	function getProvince() {
		$.ajax({
			type : 'post',
			url : "${ctx}/register/getProvince.shtml",
			dataType : 'json',
			success : function(result) {
				$.each(result, function(entryIndex, entry) {
					var html = "<option value='" + entry.id + "'>" + entry.name
							+ "</option>";
					$("#selprovince").append(html);
					;
				});
			}
		});
	}

	function getCity() {
		//清空市这个下拉选当中除了请选择之外的所有option
		$("#selcity option[value!=0]").remove();
		//清空渔区这个下拉选
		$("#selarea option[value!=0]").remove();
		//获取省这个下拉选对象
		var object = $("#selprovince");
		if (object.val() != 0) {
			$.ajax({
				type : 'post',
				url : "${ctx}/register/getCity.shtml?id=" + object.val(),
				dataType : 'json',
				success : function(result) {
					$.each(result, function(entryIndex, entry) {
						var html = "<option value='" + entry["id"] + "'>"
								+ entry["name"] + "</option>";
						$("#selcity").append(html);
					});
				}
			});
		}
	}

	function getArea() {
		$("#selarea option[value!=0]").remove();
		var object = $("#selcity");
		if (object.val() != 0) {
			$.ajax({
				type : 'post',
				url : "${ctx}/register/getCity.shtml?id=" + object.val(),
				dataType : 'json',
				success : function(result) {
					$.each(result, function(entryIndex, entry) {
						var html = "<option value='" + entry["id"] + "'>"
								+ entry["name"] + "</option>";
						$("#selarea").append(html);
					});
				}
			});
		}
	}
</script>
</head>

<body onload="getProvince()">
	<div class="wid top1">
		<img src="${ctx}/images/logo1.jpg" />
	</div>
	<div class="zhuce">
		<div class="wid">
			<form method="post" id="registerForm"
				action="${ctx}/register/register.shtml">
				<div class="zhuce_wid">
					<div class="zhuce_title">注册新账户</div>
					<div class="f-cb zhuce_tt">
						<span>用户名:</span> <input type="text" placeholder="用户名"
							name="loginName" id="loginName"> <em>*</em> <i
							id="loginNameTip"
							style="font-size:14px;width:250px;font-style:normal;"></i>
					</div>
					<div class="f-cb zhuce_tt">
						<span>手机号:</span> <input type="text" placeholder="手机号"
							name="telnum" id="telnum"> <em>*</em> <i id="telnumTip"
							style="font-size:14px;width:250px;font-style:normal;"></i>
					</div>
					<div class="f-cb zhuce_tt">
						<span>邮箱:</span> <input type="text" placeholder="邮箱" name="email"
							id="email" /> <em>*</em> <i id="emailTip"
							style="font-size:14px;width:250px;font-style:normal;"></i>
					</div>
					<div class="f-cb zhuce_tt">
						<span>设置密码:</span> <input type="password" placeholder="设置密码"
							name="password" id="password1" /> <em>*</em> <i id="password1Tip"
							style="font-size:14px;width:250px;font-style:normal;"></i>
					</div>
					<div class="f-cb zhuce_tt">
						<span>确认密码:</span> <input type="password" placeholder="确认密码"
							name="password1" id="password2" /> <em>*</em> <i
							id="password2Tip"
							style="font-size:14px;width:250px;font-style:normal;"></i>

					</div>
					<div class="f-cb zhuce_tt">
						<span>汽配商名称:</span> <input type="text" placeholder="汽配商名称"
							name="companyname" id="companyname" /> <em>*</em> <i
							id="companynameTip"
							style="font-size:14px;width:250px;font-style:normal;"></i>
					</div>
					<div class="f-cb zhuce_tt">
						<span>汽配商联系人:</span> <input type="text" placeholder="汽配商联系人"
							name="username" id="username" /> <em>*</em> <i id="usernameTip"
							style="font-size:14px;width:250px;font-style:normal;"></i>
					</div>
					<div class="f-cb zhuce_tt">
						<span>QQ号码:</span> <input type="text" placeholder="QQ号码" name="qq"
							id="qq" /> <em>*</em> <i id="qqTip"
							style="font-size:14px;width:250px;font-style:normal;"></i>
					</div>
					<div class="f-cb zhuce_tt">
						<span>固定电话:</span> <input type="text" placeholder="区号1"
							class="mar6" style="width:50px;" name="zone1" id="zone1"><input
							type="text" placeholder="座机号1" class="mar6" style="width:150px;"
							name="tel1" id="tel1" />
							<input type="text" placeholder="区号2"
							class="mar6" style="width:50px;" name="zone2" id="zone2"><input
							type="text" placeholder="座机号2" class="mar6" style="width:150px;"
							name="tel2" id="tel2" />
					</div>

					<div class="f-cb zhuce_tt">
						<select id="selprovince" onchange="getCity()" class="city-area"
							name="procince">
							<option value="0">-请选择省份-</option>
						</select> <select id="selcity" onchange="getArea()" class="city-area"
							name="city">
							<option value="0">-请选择城市-</option>
						</select> <select id="selarea" class="city-area" name="county">
							<option value="0">-请选择地区-</option>
						</select> <span>详细地址:</span> <input type="text" placeholder="详细地址"
							name="address" id="address"/> <em>*</em>

							<div class="clear"></div>
					</div>

					<div class="f-cb zhuce_tt zhuce_bg">
						<div class="tt_tt">经营范围:</div>

						<ul>
							<input type="hidden" name="manageStyle" id="manageStyle"/>
							<li style="width:880px"><button class="tt_btn"
									onclick="duozhong(this);" type="button">多种品牌</button>
								<p class="manage_mode1" style="padding-left:15px;"/>
									主营: <select name="manageDetail">
										<c:forEach var="brand" items="${brandList}">
											<option value="${brand.brandName}">${brand.brandName}</option>

										</c:forEach>

									</select></li>
							<li style="width:880px"><button class="tt_btn"
									onclick="danyi(this);" type="button">单一品牌</button>
								<p class="manage_mode2" style="padding-left:15px;">
									专营: <select name="manageDetail">
										<c:forEach var="brand" items="${brandList}">
											<option value="${brand.brandName}">${brand.brandName}</option>

										</c:forEach>

									</select>

								</p></li>
							<li style="width:880px"><button class="tt_btn"
									onclick="zhuanlei(this);" type="button">单项配件</button>
								<p class="manage_mode3" style="padding-left:15px;"/>
									配件: <select name="manageDetail">
										<c:forEach var="parts" items="${partsList}">
											<option value="${parts.partsName}">${parts.partsName}</option>

										</c:forEach>

									</select></li>

							<li style="width:880px"><button class="tt_btn"
									onclick="prime(this);" type="button">精品专卖</button>
								<p class="manage_mode4" style="padding-left:15px;"/>
									精品: <select name="manageDetail">
										<c:forEach var="prime" items="${primeList}">
											<option value="${prime.primeName}">${prime.primeName}</option>

										</c:forEach>

									</select></li>
						</ul>
						<div class="clear"></div>
					</div>
					<div class="f-mt-25 zhuce_tt">
						<button class="tt_btn1" style="cursor:pointer;" id="button">立即注册</button>
						<strong>点击“立即注册”，即表示您同意修配连&nbsp;<a href="javascript:;"
							onclick="getProtocol()">用户协议</a>&nbsp;和&nbsp;<a
							href="javascript:;" onclick="getProtocol()">隐私政策</a></strong>
					</div>

				</div>
			</form>
		</div>
	</div>

	<div class="footer">Copyright © 2014-2024 www.xiupeilian.com All
		Rights Reserved. 修配连 版权所有</div>
	<script type="text/javascript">
		function duozhong(obj) {
			var checkChexing = false;
			$(".chexing").each(function(i, val) {
				if (val.value != "") {
					checkChexing = true;
				}

			});

			if (checkChexing) {
				if (confirm('如果您切换经营范围，刚才录入的值将会被清空？')) {
					$(".chexing").each(function(i, val) {
						val.value = "";
					});
					$("#zhuanyingmiaoshu").empty();
					$(".tt_btn").css("background", "#efede4");
					$(".tt_btn").css("color", "#666");
					obj.style = "background:#c30d23;color:#fff";
					$(".manage_mode1").css("display", "inline");
					$(".manage_mode2").css("display", "none");
					$(".manage_mode3").css("display", "none");
					$(".manage_mode4").css("display", "none");
				} else {
					return;
				}
			} else {
				$(".tt_btn").css("background", "#efede4");
				$(".tt_btn").css("color", "#666");
				obj.style = "background:#c30d23;color:#fff";
				$(".manage_mode1").css("display", "inline");
				$(".manage_mode2").css("display", "none");
				$(".manage_mode3").css("display", "none");
				$(".manage_mode4").css("display", "none");
			}
			document.getElementById("manageStyle").value = "1";
		}

		function danyi(obj) {
			var checkChexing = false;
			$(".chexing").each(function(i, val) {
				if (val.value != "") {
					checkChexing = true;
				}

			});

			if (checkChexing) {
				if (confirm('如果您切换经营范围，刚才录入的值将会被清空？')) {
					$(".chexing").each(function(i, val) {
						val.value = "";
					});
					$("#zhuanyingmiaoshu").empty();
					$(".tt_btn").css("background", "#efede4");
					$(".tt_btn").css("color", "#666");
					obj.style = "background:#c30d23;color:#fff";
					$(".manage_mode1").css("display", "none");
					$(".manage_mode2").css("display", "inline");
					$(".manage_mode3").css("display", "none");
					$(".manage_mode4").css("display", "none");
				} else {
					return;
				}
			} else {
				$(".tt_btn").css("background", "#efede4");
				$(".tt_btn").css("color", "#666");
				obj.style = "background:#c30d23;color:#fff";
				$(".manage_mode1").css("display", "none");
				$(".manage_mode2").css("display", "inline");
				$(".manage_mode3").css("display", "none");
				$(".manage_mode4").css("display", "none");
			}
			document.getElementById("manageStyle").value = "2";
		}

		function zhuanlei(obj) {
			var checkChexing = false;
			$(".chexing").each(function(i, val) {
				if (val.value != "") {
					checkChexing = true;
				}

			});

			if (checkChexing) {
				if (confirm('如果您切换经营范围，刚才录入的值将会被清空？')) {
					$(".chexing").each(function(i, val) {
						val.value = "";
					});
					$("#zhuanyingmiaoshu").empty();
					$(".tt_btn").css("background", "#efede4");
					$(".tt_btn").css("color", "#666");
					obj.style = "background:#c30d23;color:#fff";
					$(".manage_mode1").css("display", "none");
					$(".manage_mode2").css("display", "none");
					$(".manage_mode3").css("display", "inline");
					$(".manage_mode4").css("display", "none");
				} else {
					return;
				}
			} else {
				$(".tt_btn").css("background", "#efede4");
				$(".tt_btn").css("color", "#666");
				obj.style = "background:#c30d23;color:#fff";
				$(".manage_mode1").css("display", "none");
				$(".manage_mode2").css("display", "none");
				$(".manage_mode3").css("display", "inline");
				$(".manage_mode4").css("display", "none");
			}
			document.getElementById("manageStyle").value = "3";
		}

		function prime(obj) {
			var checkChexing = false;
			$(".chexing").each(function(i, val) {
				if (val.value != "") {
					checkChexing = true;
				}

			});

			if (checkChexing) {
				if (confirm('如果您切换经营范围，刚才录入的值将会被清空？')) {
					$(".chexing").each(function(i, val) {
						val.value = "";
					});
					$("#zhuanyingmiaoshu").empty();
					$(".tt_btn").css("background", "#efede4");
					$(".tt_btn").css("color", "#666");
					obj.style = "background:#c30d23;color:#fff";
					$(".manage_mode1").css("display", "none");
					$(".manage_mode2").css("display", "none");
					$(".manage_mode3").css("display", "none");
					$(".manage_mode4").css("display", "inline");
				} else {
					return;
				}
			} else {
				$(".tt_btn").css("background", "#efede4");
				$(".tt_btn").css("color", "#666");
				obj.style = "background:#c30d23;color:#fff";
				$(".manage_mode1").css("display", "none");
				$(".manage_mode2").css("display", "none");
				$(".manage_mode3").css("display", "none");
				$(".manage_mode4").css("display", "inline");
			}
			document.getElementById("manageStyle").value = "4";
		}

		function toCarmodel(flag, version) {
			top.$.jBox("iframe:${ctx}/loginAction.do?method=toCarmodel&flag="
					+ flag + "&version=" + version, {
				title : "车型车系",
				attach : $('#idett'),
				width : 1024,
				height : 600,
				buttons : { /*'关闭': true*/}
			});
		}

		function toParts() {
			top.$.jBox("iframe:${ctx}/loginAction.do?method=toParts", {
				title : "单项配件",
				attach : $('#idett'),
				width : 680,
				height : 720,
				buttons : { /*'关闭': true*/}
			});
		}

		function toPrime() {
			top.$.jBox("iframe:${ctx}/loginAction.do?method=toPrime", {
				title : "精品专卖",
				attach : $('#idett'),
				width : 680,
				height : 720,
				buttons : { /*'关闭': true*/}
			});
		}

		function subData() {
			$(".chexing").each(function(i, val) {
				if (val.value != null && val.value != '') {
					checkChexing = true;
				}

			});
			if (!checkTel()) {
				alert("固定电话必须符合格式(区号+座机号)");
				return;
			}

			if ($("#address").val() == '') {
				alert("详细地址不能为空");
				return;
			}

			$("#registerForm").attr("action", "${ctx}/register.action")
					.submit();
		}

		function getProtocol() {

			/* top.$.jBox("iframe:${ctx}/loginAction.do?method=getProtocol", {
				title : "法律声明",
				width :1024,
				height : 720,
				buttons : { /*'关闭': true}
			}); 
			 */
			var request = new XMLHttpRequest();
			request.onreadystatechange = function() {
				var DONE = this.DONE || 4;
				if (this.readyState === DONE) {
					alert(request.responseText);
				}
			};
			request.open('GET', '${ctx}/loginAction.do?method=register', true);
			//
			request.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
			request.send(null);
		}

		function checkTel() {
			var isZone = /^0\d{2,3}$/;
			var isPhone = /^\d{7,8}$/;
			var tel1 = document.getElementById("tel1").value.trim();
			var tel2 = document.getElementById("tel2").value.trim();
			var zone1 = document.getElementById("zone1").value.trim();
			var zone2 = document.getElementById("zone2").value.trim();
			if (tel1 == "" && tel2 == "" && zone1 == "" && zone2 == "") {
				return true;
			} else {
				if (isZone.test(zone1) && isPhone.test(tel1)) {
					if ((tel2 == "" && zone2 == "")
							|| (isZone.test(zone2) && isPhone.test(tel2))) {
						return true;
					} else {
						return false;
					}
				} else {
					if (isZone.test(zone2) && isPhone.test(tel2)) {
						if ((tel1 == "" && zone1 == "")
								|| (isZone.test(zone1) && isPhone.test(tel1))) {
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}
				}
			}
		}
	</script>
</body>