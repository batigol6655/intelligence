var Chat = new function() {
	/** 发送聊天信息 */
	this.sendMsg = function() {
		var channel = $("#sltChannel").val();//频道
		var msg = $("#msg").val();//消息
		if (msg == null || jQuery.trim(msg) == "") {
			return;
		}
		var convertMsg = this.checkMsg(msg);
		if (convertMsg.isPM) {// 如果是私聊
			ChatServer.send("4", convertMsg.msg, convertMsg.to);
		} else {
			ChatServer.send(channel, convertMsg.msg, convertMsg.to);
		}

		$("#msg").val("");
	}

	/** 接受聊天信息 */
	this.receive = function(data) {
		if (data == null || data == "") {
			return;
		}
		var content = "";
		content += data.sender + ":" + data.msg + "<br />";
		switch (data.type) {
			case "0" :// 当前
				$("#divMsgLocal").html($("#divMsgLocal").html() + content);
				break;
			case "1" :// 班级
				$("#divMsgClazz").html($("#divMsgClazz").html()
						+ "<span style='color:"
						+ (data.state == -1 ? "red" : "#B5B832;") + "'>"
						+ content + "</span>");
				break;
			case "2" :// 社团
				$("#divMsgAsso").html($("#divMsgAsso").html()
						+ "<span style='color:"
						+ (data.state == -1 ? "red" : "#6081E3;") + "'>"
						+ content + "</span>");
				break;
			case "3" :// 世界
				$("#divMsgWorld").html($("#divMsgWorld").html()
						+ "<span style='color:"
						+ (data.state == -1 ? "red" : "cyan;") + "'>" + content
						+ "</span>");
				break;
			case "4" :// 私聊
				$("#divMsgLocal").html($("#divMsgLocal").html()
						+ "<span style='color:"
						+ (data.state == -1 ? "red" : "green;") + "'>"
						+ content + "</span>");
				break;
			case "5" :// 系统
				$("#divMsgSys").html($("#divMsgSys").html()
						+ "<span style='color:red;'>" + content + "</span>");
				break;
			default :
				break;
		}

		$("#divMsgLocal").attr("scrollTop",$("#divMsgLocal").attr("scrollHeight"));
		$("#divMsgClazz").attr("scrollTop",$("#divMsgClazz").attr("scrollHeight"));
		$("#divMsgAsso").attr("scrollTop",$("#divMsgAsso").attr("scrollHeight"));
		$("#divMsgWorld").attr("scrollTop",$("#divMsgWorld").attr("scrollHeight"));
		$("#divMsgSys").attr("scrollTop", $("#divMsgSys").attr("scrollHeight"));
	}

	/**
	 * 判断当前是否是私聊 私聊格式为: /角色名 聊天信息
	 */
	this.checkMsg = function(data) {
		var c1 = data.indexOf("/");
		var c2 = data.indexOf(" ");
		if (c1 == 0 && c2 > 1) {// 说明是私聊
			return {
				isPM : true,
				msg : data.substr(c2 + 1),
				to : data.substr(c1 + 1, c2 - c1 - 1)
			};
		} else {
			return {
				isPM : false,
				msg : data,
				to : ""
			};
		}
	}

	/** 用回车键进行发送消息 */
	this.keySendMsg = function(e) {
		e = e || event;
		if (e.keyCode == 13) {
			this.sendMsg();
		}
	}
}
