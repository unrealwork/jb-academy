function Api() {

    let get = function (url, success, error) {
        let xhr = new XMLHttpRequest();
        xhr.open("GET", url, true);
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhr.onload = function (e) {
            if (xhr.readyState === 4) {
                if (xhr.status >= 200 && xhr.status < 300) {
                    success(JSON.parse(xhr.response))
                } else {
                    if (error) {
                        error()
                    }
                }
            }
        };
        xhr.onerror = function (e) {
            error();
        };
        xhr.send(null);
    }

    Api.prototype.code = function (success, error) {
        get('/api/code', success, error)
    }
}

window.API = new Api();

document.addEventListener('DOMContentLoaded', function () {
    const elements = {
        codeSnippet: document.getElementById('code_snippet'),
        loadDate: document.getElementById('load_date')
    }


    API.code(function (data) {
        if (data.timestamp) {
            const dt = new Date(data.timestamp);
            let ruLocale = 'ru-RU';
            elements.loadDate.innerText = dt.toLocaleDateString(ruLocale) + ' ' + dt.toLocaleTimeString(ruLocale);
        }
        elements.codeSnippet.innerHTML = data.code;
    })
})


