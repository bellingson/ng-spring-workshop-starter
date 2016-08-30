
var link = document.getElementById('logout');
if(link) {
    link.addEventListener('click', function(event) {
        event.preventDefault();
        document.getElementById('logout-form').submit();
    });
}
