/**
 * 
 */
 const messagesUl = document.querySelector('#messagesUl');

    const accountchat = localStorage.getItem('memId');

    const webSocket = new WebSocket(getUri());

    webSocket.addEventListener('open', e => {
        console.log('連線成功');
    });

    webSocket.addEventListener('message', e => {
        const obj = JSON.parse(e.data);
        messagesUl.innerHTML += `
        	<li class="other">
        		${obj.content}
	        	<small style="position: absolute; right: -55px; width: 50px; top: 24px;">
	        		${getCurrentTimeZoneFormat()}
	        	</small>
	        </li>`;
        messagesUl.scrollTo(0, messagesUl.scrollHeight);
    });

    webSocket.addEventListener('close', e => {
        console.log('連線失敗');
    });

    function getCurrentTimeZoneFormat() {
        return new Date().toLocaleString('en-US', {
            hour: 'numeric',
            minute: 'numeric',
            hour12: true,
        });
    }

    function getUri() {
        const endPoint = `/ChatEndpoint/${accountchat}/user`;
        const { host, pathname } = location;
        const webCtx = pathname.substring(0, pathname.indexOf('/', 1));
        return 'ws://' + host + webCtx + endPoint;
    }

    document.querySelector('#sendMessage').addEventListener('click', () => {
        webSocket.send(JSON.stringify({
            type: 'MESSAGE',
            sender: accountchat,
            content: messageDiv.textContent
        }));
    });