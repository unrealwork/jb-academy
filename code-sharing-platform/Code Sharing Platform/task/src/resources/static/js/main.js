const API = {
    get : function (success, error) {
        let xhr = new XMLHttpRequest();
        xhr.open("GET", "/api/code", true);
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhr.onload = function (e) {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    success()
                } else {
                    error()
                }
            }
        };
        xhr.onerror = function (e) {
            error();
        };
        xhr.send(null);
    }
}

API.get(function (){
    console.log('Resp is received')
})
