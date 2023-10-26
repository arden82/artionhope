const username = sessionStorage.getItem("MyKeyName");
const webSocket = new WebSocket(getUri());
const messageIp = document.querySelector('#messageIp');
const messageDiv = document.querySelector('#messageDiv');
const userListUl = document.querySelector('#userListUl');
const mainContentDiv = document.querySelector('#mainContentDiv');
const curAvatarSp = document.querySelector('#curAvatarSp');
const curUsernameH6 = document.querySelector('#curUsernameH6');

let curReceiver;

webSocket.addEventListener('open', e => {
    console.log('連線成功');
});

webSocket.addEventListener('message', e => {
    const msg = JSON.parse(e.data);
    const { sender } = msg;
    switch (msg.type) {
        case 'ONLINE':
            userListUl.innerHTML += `
                    <li id="${sender}Li" class="card contact-item mb-3" onclick="changeChat('${sender}')">
                        <div class="card-body">
                            <div class="d-flex align-items-center">
                                <div class="avatar avatar-online me-4">
                                    <span class="avatar-label bg-info text-white">${sender[0]}</span>
                                </div>
                                <div class="flex-grow-1 overflow-hidden">
                                    <div class="d-flex align-items-center mb-1">
                                        <h5 class="text-truncate mb-0 me-auto">${sender}</h5>
                                    </div>
                                    <div class="d-flex align-items-center">
                                        <div class="text-truncate me-auto">Online</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>`;
            break;
        case 'MESSAGE':
            const time = getCurrentTimeZoneFormat();
            messageDiv.innerHTML += createMessageTemplate(msg.content, time, false);
            saveChatMsgList(false, time, msg.content);
            break;
        case 'OFFLINE':
            document.querySelector(`#${sender}Li`)?.remove();
            break;
    }
});

webSocket.addEventListener('close', e => {
    console.log('連線失敗');
});

document.querySelector('#sendBtn').addEventListener('click', () => {
    webSocket.send(JSON.stringify({
        type: 'MESSAGE',
        sender: username,
        receiver: curReceiver,
        content: messageIp.value
    }));
    const time = getCurrentTimeZoneFormat();
    saveChatMsgList(true, time, messageIp.value);
    messageDiv.innerHTML += createMessageTemplate(messageIp.value, time, true);
    // 		messageDiv.scrollTo(0, messageDiv.scrollHeight);
    messageIp.value = '';
    scrollMessageToBottom();
});

function createMessageTemplate(message, now, isSelf) {
    const info = `<div class="message-info align-items-end me-2">
  						<div>
  							<small class="text-muted">${now}</small>
					  	</div>
					  </div>`;
    const item = `<div class="message-item">
		      			<div class="message-content">
	        				<span>${message}</span>
	      				</div>
	    			  </div>`;
    return `
			<div class="message ${isSelf ? 'self' : ''}">
			  <div class="message-wrap d-flex">
			  		${isSelf ? info + item : item + info}			    
			  </div>
			</div>
		`
}

function getCurrentTimeZoneFormat() {
    return new Date().toLocaleString('en-US', { hour: 'numeric', minute: 'numeric', hour12: true })
}

function getUri() {
    const endPoint = `/ChatEndpoint/${username}`;
    const { host, pathname } = location;
    const webCtx = pathname.substring(0, pathname.indexOf('/', 1));
    return "ws://" + location.host + webCtx + endPoint;
}

function scrollMessageToBottom() {
    document.querySelector('.js-scroll-to-bottom').scrollIntoView({
        block: 'end',
        behavior: 'instant'
    })
}

function changeChat(receiver) {
    mainContentDiv.style.display = 'block';
    curAvatarSp.textContent = receiver[0];
    curUsernameH6.textContent = receiver;
    curReceiver = receiver;

    const chatMsgList = JSON.parse(localStorage.getItem(`chatMsgList_${curReceiver}`)) ?? [];
    messageDiv.innerHTML = '';
    for (let chatMsg of chatMsgList) {
        const { isSelf, time, content } = chatMsg;
        messageDiv.innerHTML += createMessageTemplate(content, time, isSelf);
    }

}

function saveChatMsgList(isSelf, time, content) {
    const key = `chatMsgList_${curReceiver}`;
    const chatMsgList = JSON.parse(localStorage.getItem(key)) ?? [];
    chatMsgList.push({
        isSelf,
        time,
        content
    });
    localStorage.setItem(key, JSON.stringify(chatMsgList));
}