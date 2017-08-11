function load(trID) {
    var word =  document.getElementById('deletelink').href.split('id=');
    document.getElementById('deletelink').href = word[0] + 'id=' + trID;
    word = document.getElementById('deletelink').innerText.split(":");
    document.getElementById('deletelink').innerText = word[0] + ':' + trID
}