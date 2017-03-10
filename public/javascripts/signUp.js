 $(document).ready(function(){

 $('#signUp').on("click",function(){
            /*alert("clicked")*/
                console.log($('#name').val())
                console.log("clicked")
                jsRoutes.controllers.SignUpController.addAccount($('#name').val(),$('#username').val(),
                                $('#password').val(),$('#confirm').val()).ajax({
                            success: function(data){
                              $('#body').html(data);

                            },
                            error: function(){
                            $('#body').html("hello");
                            alert("fail")
                          }

                })


            })
});