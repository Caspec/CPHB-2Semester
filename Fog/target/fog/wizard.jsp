<%@page import="domain.entity.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.ItemMapper"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Fog Admin | Step wizard</title>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src="http://cdn.ckeditor.com/4.6.1/standard/ckeditor.js"></script>
        <link rel="icon" href="img/geekfav.png" sizes="32x32" />

        <!-- Include Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <!-- Optional Bootstrap theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- Include SmartWizard CSS -->
        <link href="dist/css/smart_wizard.css" rel="stylesheet" type="text/css" />

        <!-- Optional SmartWizard theme -->
        <link href="dist/css/smart_wizard_theme_dots.css" rel="stylesheet" type="text/css" />

    </head>
    <body>

        <nav class="navbar navbar-default">
            <div class="container">

            </div>
        </nav>

        <header id="header">
            <div class="container">
                <div class="row">
                    <div class="col-md-10">
                        <h1> Fog Trælast & Byggecenter <small>Her har du alle muligheder!</small></h1>
                    </div>
                    <div class="col-md-2">

                    </div>
                </div>
            </div>
        </header>
        <% ItemMapper im = new ItemMapper(); %>
            


        <section id="main">
            <div class="container">
                <div class="row">

                    <div class="col-md-3">	
                    </div>
                    <div class="col-md-9">


                        <div class="container">
                            <br />
                            <form action="ControlInsertUserData" id="myForm" role="form" data-toggle="validator" method="post" accept-charset="utf-8">

                                <!-- SmartWizard html -->
                                <div id="smartwizard">
                                    <ul>
                                        <li><a href="#step-1">Step 1<br /><small>Vælg mål</small></a></li>
                                        <li><a href="#step-2">Step 2<br /><small>Vælg materialer</small></a></li>
                                        <li><a href="#step-3">Step 3<br /><small>Indtast kundeinformationer</small></a></li>
                                        <li><a href="#step-4">Step 4<br /><small>Oversigt af ordren</small></a></li>
                                    </ul>

                                    <div>
                                        <div id="step-1">
                                            <h2>Vælg mål</h2>
                                            <div id="form-step-0" role="form" data-toggle="validator">
                                                <div class="form-group">
                                                    
                                                    <label for="length">Længde:</label>
                                                    <select class="form-control" name="length" required>
                                                        <option class="form-control" value="300">300cm</option>
                                                        <option class="form-control" value="330">330cm</option>
                                                        <option class="form-control" value="360">360cm</option>
                                                        <option class="form-control" value="390">390cm</option>
                                                        <option class="form-control" value="420">420cm</option>
                                                        <option class="form-control" value="450">450cm</option>
                                                        <option class="form-control" value="480">480cm</option>
                                                        <option class="form-control" value="510">510cm</option>
                                                        <option class="form-control" value="540">540cm</option>
                                                        <option class="form-control" value="570">570cm</option>
                                                        <option class="form-control" value="600">600cm</option>
                                                        <option class="form-control" value="630">630cm</option>
                                                     </select>
                                                    
                                                   <label for="width">Brede:</label>
                                                    <select class="form-control" name="width" required>
                                                        <option class="form-control" value="210">210cm</option>
                                                        <option class="form-control" value="240">240cm</option>
                                                        <option class="form-control" value="270">270cm</option>
                                                        <option class="form-control" value="300">300cm</option>
                                                        <option class="form-control" value="330">330cm</option>
                                                        <option class="form-control" value="360">360cm</option>
                                                        <option class="form-control" value="390">390cm</option>
                                                        <option class="form-control" value="420">420cm</option>
                                                        <option class="form-control" value="450">450cm</option>
                                                        <option class="form-control" value="480">480cm</option>
                                                        <option class="form-control" value="510">510cm</option>
                                                     </select>
                                                   
                                                   <label for="height">Højde:</label>
                                                    <select class="form-control" name="height" required>
                                                        <option class="form-control" value="150">150cm</option>
                                                        <option class="form-control" value="180">180cm</option>
                                                        <option class="form-control" value="210">210cm</option>
                                                        <option class="form-control" value="240">240cm</option>
                                                        <option class="form-control" value="270">270cm</option>
                                                        
                                                     </select>
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </div>

                                        </div>
                                        <div id="step-2">
                                            <h2>Vælg materialer</h2>
                                            <div id="form-step-1" role="form" data-toggle="validator">
                                                <div class="form-group">
                                                    
                                                    <label for="floor">Gulv:</label>
                                                    <select class="form-control" name="floor" required>
                                                        <% 
                                                            ArrayList<Item> floorList = new ArrayList<>();
                                                            floorList = im.getAllItemByTypeId(4);
                                                            for(int i =0; i < floorList.size(); i++)
                                                            {
                                                                %>
                                                                <option class="form-control" value="<% out.print(floorList.get(i).getItem_id()); %>"><% out.print(floorList.get(i).getItem_name()); %></option> 
                                                               <%
                                                            }
                                                        %>
                                                       
                                                     </select>
                                                    
                                                    <label for="roof">Tag:</label>
                                                    <select class="form-control" name="roof" required>
                                                        <% 
                                                            ArrayList<Item> roofList = new ArrayList<>();
                                                            roofList = im.getAllItemByTypeId(2);
                                                            for(int i =0; i < roofList.size(); i++)
                                                            {
                                                                %>
                                                                <option class="form-control" value="<% out.print(roofList.get(i).getItem_id()); %>"><% out.print(roofList.get(i).getItem_name()); %></option> 
                                                               <%
                                                            }
                                                        %>
                                                     </select>
                                                    
                                                    <label for="side">Sider:</label>
                                                    <select class="form-control" name="side" required>
                                                        <% 
                                                            ArrayList<Item> sideList = new ArrayList<>();
                                                            sideList = im.getAllItemByTypeId(3);
                                                            for(int i =0; i < sideList.size(); i++)
                                                            {
                                                                %>
                                                                <option class="form-control" value="<% out.print(sideList.get(i).getItem_id()); %>"><% out.print(sideList.get(i).getItem_name()); %></option> 
                                                               <%
                                                            }
                                                        %>
                                                     </select>
                                                    
                                                    
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="step-3">
                                            <h2>Indtast kundeinformationer</h2>
                                            <div id="form-step-2" role="form" data-toggle="validator">
                                                <div class="form-group">
                                                    
                                                    <label for="name">Navn: </label>
                                                    <input type="text" name="name" class="form-control" required>
                                                    <label for="email">Email: </label>
                                                    <input type="email" name="email" class="form-control" required>
                                                    <label for="adress">Adresse: </label>
                                                    <input type="text" name="adress" class="form-control" required>
                                                    <label for="phone">Telefon: </label>
                                                    <input type="number" name="phone" class="form-control" required>
                                                    <label for="zip">Postnummer: </label>
                                                    <input type="text" name="zip" class="form-control" required>
                                                    
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="step-4" class="">
                                            <h2>Oversigt af ordren</h2>
                                            
                                            <div id="form-step-3" role="form" data-toggle="validator">
                                                <div class="form-group">
                                                    <label>OBS. Husk at du ikke køber en færdig carport, men kun materialer.</label>
                                                    <label>OBS. Der høre ikke værktøj med i købet, det skal man selv sørge for. Der skal bruges:</label>
                                                    <ul>
                                                        <li>Boremaskine</li>
                                                        <li>Flad Skruetrækker</li>
                                                        <li>Vatterpas</li>
                                                        <li>Umbraco nøgler</li>
                                                        <li>Skovl</li>
                                                    </ul>
                                                    
                                                    <label>OBS. Husk at hvis du ønsker strøm mm. i din carport skal du bruge en aut. elektriker.</label>
                                                    <label>Fog vil kontakte dig 14 dage efter levering, for at chekke op på at alt er gået godt eller om der har været nogle problemer.</label>
                                                    <label for="terms">Jeg acceptere handelsbetingelserne fra FOG</label>
                                                    <input type="checkbox" id="terms" data-error="Venligst acceptere handelsbetingelserne." required>  
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <footer id="footer">
            <p>Copyright Sjov med skæg &copy; 2017</p>
        </footer>


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <!-- Include jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include jQuery Validator plugin -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.5/validator.min.js"></script>


        <!-- Include SmartWizard JavaScript source -->
        <script type="text/javascript" src="dist/js/jquery.smartWizard.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {

                // Toolbar extra buttons
                var btnFinish = $('<button></button>').text('Afslut')
                        .addClass('btn btn-info')
                        .on('click', function () {
                            if (!$(this).hasClass('disabled')) {
                                var elmForm = $("#myForm");
                                if (elmForm) {
                                    elmForm.validator('validate');
                                    var elmErr = elmForm.find('.has-error');
                                    if (elmErr && elmErr.length > 0) {
                                        alert('Oops vi har en form for fejl i wizarden som ikke er udfyldt! Udfyld alle punkter!');
                                        return false;
                                    } else {
                                        alert('Godt! vi er klar til at tage imod din bestilling!');
                                        elmForm.submit();
                                        return false;
                                    }
                                }
                            }
                        });
                var btnCancel = $('<button></button>').text('Annullere')
                        .addClass('btn btn-danger')
                        .on('click', function () {
                            $('#smartwizard').smartWizard("reset");
                            $('#myForm').find("input, textarea").val("");
                        });



                // Smart Wizard
                $('#smartwizard').smartWizard({
                    selected: 0,
                    theme: 'dots',
                    transitionEffect: 'fade',
                    toolbarSettings: {toolbarPosition: 'bottom',
                        toolbarExtraButtons: [btnFinish, btnCancel]
                    },
                    anchorSettings: {
                        markDoneStep: true, // add done css
                        markAllPreviousStepsAsDone: true, // When a step selected by url hash, all previous steps are marked done
                        removeDoneStepOnNavigateBack: true, // While navigate back done step after active step will be cleared
                        enableAnchorOnDoneStep: true // Enable/Disable the done steps navigation
                    }
                });

                $("#smartwizard").on("leaveStep", function (e, anchorObject, stepNumber, stepDirection) {
                    var elmForm = $("#form-step-" + stepNumber);
                    // stepDirection === 'forward' :- this condition allows to do the form validation 
                    // only on forward navigation, that makes easy navigation on backwards still do the validation when going next
                    if (stepDirection === 'forward' && elmForm) {
                        elmForm.validator('validate');
                        var elmErr = elmForm.children('.has-error');
                        if (elmErr && elmErr.length > 0) {
                            // Form validation failed
                            return false;
                        }
                    }
                    return true;
                });

                $("#smartwizard").on("showStep", function (e, anchorObject, stepNumber, stepDirection) {
                    // Enable finish button only on last step
                    if (stepNumber == 3) {
                        $('.btn-finish').removeClass('disabled');
                    } else {
                        $('.btn-finish').addClass('disabled');
                    }
                });

            });
        </script>  

    </body>
</html>
