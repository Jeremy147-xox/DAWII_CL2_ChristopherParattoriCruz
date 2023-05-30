$(document).ready(function() {
    $("#togglePassword").click(function() {
        var passwordInput = $("#password");
        var passwordInputType = passwordInput.attr("type");

        if (passwordInputType === "password") {
            passwordInput.attr("type", "text");
            $("#togglePassword").html('<i class="fas fa-eye-slash"></i>');
        } else {
            passwordInput.attr("type", "password");
            $("#togglePassword").html('<i class="fas fa-eye"></i>');
        }
    });
});