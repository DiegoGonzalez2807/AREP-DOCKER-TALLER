
function insertChain(){
    //var URL_API = "https://serene-bastion-37080.herokuapp.com/search/"+APIRedirect+"/"+document.getElementById("empresa").value;
    var URL_API = "http://localhost:4567/insert/"+document.getElementById("cadena").value;
    axios.get(URL_API)
        .then(function(res){
        console.log("FUNCIONAL")
        console.log(res.data)
        printingInformation(res.data)
        })
        .catch(function (error) {
            console.log(error)
        })
}

function printingInformation(info){
    console.log(info.length)
    info.map(possibleMap)
    
}

function possibleMap(info){
    div = document.getElementById("allInfo");
    div.style.visibility = "visible"
    newElement = document.createElement('div')
    var newObj = {};
    newObj.value = info.Value;
    console.log(newObj.value)
    newObj.createdAt = info.createdAt;
    console.log(newObj.createdAt)
    newElement.textContext = JSON.stringify(newObj,null,2)
    div.appendChild(newElement)
}