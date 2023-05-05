$(document).ready(function() {
    $('tbody tr').on('click', function() {
        var profileUrl = $(this).find('a').attr('href');
        window.location.href = profileUrl;
    });
});
