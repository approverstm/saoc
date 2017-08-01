$(document).ready(function () {
 
            (function ($) {
                var fil1;
                $('#filtrar').keyup(function () {
                    fil1 = new RegExp($(this).val(), 'i');
                    $('.buscar tr').hide();
                    $('.buscar tr').filter(function () {
                    var r = fil1.test($(this).text());
                    return r;
                    }).show();
                })
            }(jQuery));
        });
