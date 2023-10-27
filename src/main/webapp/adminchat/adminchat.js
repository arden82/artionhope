const admId = localStorage.getItem('admId');
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
    const { type, sender, content } = msg;
    switch (type) {
        case 'ONLINE':
            createReceiverTemplate(sender);
            showLastContentFromStorage(sender);
            break;
        case 'LIST':
            console.log(content);
            const receiverList = JSON.parse(content);
            for (let receiver of receiverList) {
                createReceiverTemplate(receiver);
                showLastContentFromStorage(receiver);
            }
            break;
        case 'MESSAGE':
            const time = getCurrentTimeZoneFormat();
            if (sender === curReceiver) {
                messageDiv.innerHTML += createMessageTemplate(content, time, false);
            }
            showLastContent(sender, content, time);
            saveChatMsgList(false, time, content, sender);
            moveToFirst(sender);
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
        sender: admId,
        receiver: curReceiver,
        content: messageIp.value
    }));
    const time = getCurrentTimeZoneFormat();
    showLastContent(curReceiver, messageIp.value, time);
    saveChatMsgList(true, time, messageIp.value);
    messageDiv.innerHTML += createMessageTemplate(messageIp.value, time, true);
    messageIp.value = '';
    scrollMessageToBottom();
});

function createReceiverTemplate(receiver) {
    userListUl.innerHTML += `
        <li id="${receiver}Li" class="card contact-item mb-3" onclick="changeChat('${receiver}')">
            <div class="card-body">
                <div class="d-flex align-items-center">
                    <div class="avatar avatar-online me-4">
                        <span class="avatar-label bg-info text-white">${receiver[0]}</span>
                    </div>
                    <div class="flex-grow-1 overflow-hidden">
                        <div class="d-flex align-items-center mb-1">
                            <h5 class="text-truncate mb-0 me-auto">${receiver}</h5>
                            <p id="lastTimeP${receiver}" class="small text-muted text-nowrap ms-4 mb-0"></p>
                        </div>
                        <div class="d-flex align-items-center">
                            <div id="lastContentDiv${receiver}" class="text-truncate me-auto"></div>
                        </div>
                    </div>
                </div>
            </div>
        </li>`;
}

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
    const endPoint = `/ChatEndpoint/${admId}/Admin`;
    const { host, pathname } = location;
    const webCtx = pathname.substring(0, pathname.indexOf('/', 1));
    return 'ws://' + host + webCtx + endPoint;
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
    scrollMessageToBottom();
}

function saveChatMsgList(isSelf, time, content, receiver) {
    const key = `chatMsgList_${receiver ?? curReceiver}`;
    const chatMsgList = JSON.parse(localStorage.getItem(key)) ?? [];
    chatMsgList.push({
        isSelf,
        time,
        content
    });
    localStorage.setItem(key, JSON.stringify(chatMsgList));
}

function showLastContent(receiver, content, time) {
    const lastContentDiv = document.querySelector(`#lastContentDiv${receiver}`);
    lastContentDiv.textContent = content;

    const lastTimeP = document.querySelector(`#lastTimeP${receiver}`);
    lastTimeP.textContent = time;
}

function showLastContentFromStorage(receiver) {
    const chatMsgList = JSON.parse(localStorage.getItem(`chatMsgList_${receiver ?? curReceiver}`)) ?? [];
    const lastChatMsg = chatMsgList[chatMsgList.length - 1];
    const { content, time } = lastChatMsg;
    showLastContent(receiver, content, time);
}

function moveToFirst(receiver) {
    const li = document.querySelector(`#${receiver}Li`);
    userListUl.insertBefore(li, userListUl.firstChild);
}