var FormValidation = function () {

    // basic validation
    var handleValidation1 = function() {
        // for more info visit the official plugin documentation: 
        // http://docs.jquery.com/Plugins/Validation

        var form1 = $('#register-form');
        var error1 = $('.alert-danger', form1);
        var success1 = $('.alert-success', form1);

        form1.validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block help-block-error', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",  // validate all fields including form hidden input
          
            rules: {
            	username: {
                    required: true,
                    maxlength:20,
                    remote:{
                        type:"POST",
                        url:"v_checkUsername.do",
                        data:{
                            veryCode:function(){return $("#username").val();}
                        }
                    },
                },
                realname: {
                    required: true,
                    maxlength:20,
                },
                
                password:{
                	required:true,
                	minlength:3,
                },
                password1:{
                	required:true,
                	minlength:3,
                	equalTo: "#password"
                },
                captcha:{
                	required:true,
                }
            },
            messages: {
            	username:{
            		required:"用户名不能为空",
            		username:"请准确的输入用户名",
            		remote:"该用户名已被注册",
                },
                realname:{
                	required:"真实姓名不能为空",
                	realname:"请输入正确的输入正确姓名",
                },
                password:{
                	required:"密码不能为空",
                	minlength:"密码长度不能小于3",
                },
                password1:{
                	required:"确认密码不能为空",
                	minlength:"密码长度不能小于3",
                	equalTo: "两次输入密码不相同"
                },
                captcha:{
                	required:"请输入验证码",
                }
                
                
            },

            invalidHandler: function (event, validator) { //display error alert on form submit
                success1.hide();
                error1.show();
                App.scrollTo(error1, -200);
            },

            highlight: function (element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control member.group
            },

            unhighlight: function (element) { // revert the change done by hightlight
                $(element)
                    .closest('.form-group').removeClass('has-error'); // set error class to the control member.group
            },

            success: function (label) {
                label
                    .closest('.form-group').removeClass('has-error'); // set success class to the control member.group
            },

            submitHandler: function (form) {
                success1.show();
                error1.hide();
                form[0].submit(); // submit the form
            }
        });


    };
    // basic validation
   



    return {
        //main function to initiate the module
        init: function () {
            handleValidation1();
            handleValidation2();
        }

    };

}();

jQuery(document).ready(function() {
    FormValidation.init();
});