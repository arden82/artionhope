        logoutBtn.addEventListener("click", function () {
            sessionStorage.removeItem("memId");
            sessionStorage.removeItem("account");
            localStorage.removeItem("memId");
            localStorage.removeItem("account");
            fetch(`${window.location, path}/memberlogout`, {
                method: "GET",
                redirect: "follow"
            }).then(res => {
                if (res.redirected) {
                    window.location.href = res.url;
                }
            }).catch(err => {
                console.error("登出出錯了:" + err);
            })
        })