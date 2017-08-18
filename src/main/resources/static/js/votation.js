class Fun {
    
    constructor(){
        console.log("hey joe");
        document.querySelector("#btnSend").onclick = e => this.send();
    }
    
    send(){
        var form = document.querySelector('#frmVotation');
        form.submit();
    }
}

let fun = new Fun();

