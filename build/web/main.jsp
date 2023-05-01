<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ItemModel.ItemModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>

    <!-- material css -->
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    <!-- material icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
   
           
    <nav>
        <div class="brand-logo ">
           <span ><i class=" icon large material-icons left">account_circle</i> Welcome, Ritesh</span>
        </div> 
    </nav>
    <div class="container cardone">
        <div class="card-panel green lighten-1 cardwidth">
            <marquee behaviour="scroll" scrollamount="30"><p>Products Available For Bidding</p></marquee>
        </div>
        
             <div class="row m3">
      
         <% 
              ItemModel model = new ItemModel();
              model.connectToDB();
              for(int i=0;i<model.list.size();i++){
//              out.print(model.list.get(i).getEmail());
//              out.println("<img src=\""+"Image/"+model.list.get(i).getImgUrl()+"\" alt="+model.list.get(i).getImgUrl()+" />");
              
              out.println("<div class=\"card col s3\">");
              out.println("<div class=\"card-image cardimg\">");
              out.println("<img src=\"Image/"+model.list.get(i).getImgUrl()+"\" alt=\"camera\" width=\"300px\", height=\"200px\">");
              out.println("<div class=\"card-title\">"+ model.list.get(i).getProductName()+"</div>");
              out.println("</div>");
              out.println("<div class=\"card-content\">");
              out.println("<p>"+ model.list.get(i).getProductDescription()+"+</p>");
              out.println("</div>");
              out.println("<div class=\"sellerdetails\">");
              out.println("<span>Seller : " + model.list.get(i).getUserName()+ "</span>");
              out.println("</div>");
              out.println("<hr>");
              out.println("<div class=\"priceandbid\">");
              out.println("<a class=\"btn-small left\">"+ model.list.get(i).getItemPrice()+" </a>");
              out.println("<a class=\"btn-small right\">Bid</a>");
              out.println("</div>");
              out.println("</div>");
             
              
              
        }
         %>
        
<!--       
            <div class="card col s3">
                <div class="card-image cardimg">
                    <img src="camera.jpeg" alt="camera" width="300px", height="200px">
                    <div class="card-title">Camera</div>
                </div>

                <div class="card-content">
                    <p>This is a camera. Lorem ipsum dolor sit amet consectetur adipisicing elit. </p>
                </div>
                <div class="sellerdetails">
                    <span>Seller : </span>
                </div>
                <hr>
                <div class="priceandbid">
                    <a class="btn-small left">10$</a>
                    <a class="btn-small right">Bid</a>
                </div>
            </div>
        </div>-->
 
     </div>
    <style>
    .cardone{
        margin-top: 20px;
    }
    .cardwidth{
        height: 60px;
    }
    .cardwidth p{
        text-align: center;
        justify-content: center;
        font-weight: bold;
        font-size: larger;
        margin-top: -10px;
        color: red;
        font-style: italic;
        padding: 4px;
    }
    .cardimg img{
        /* width: 100%;
        height: 100%;
        object-fit: contain;*/
        margin-top: 8px; 
    }
    .priceandbid a{
        margin-bottom: 8px;
        width: 80px;
    }
    hr{
        margin-top: 10px;
    }
    .icon{
        margin-left: 20px;
        font-size :8rem;
        transform: scale(2);
    }
    nav span{
        font-weight: bold;
        color:white;
        /* box-shadow: 3px 4px 3px; */
        text-shadow: 1px 1px 3px black ;
    }
    .sellerdetails{
        border: 2px solid green;
        width: 100%;
        height: 25px;
        border-radius: 4px;
        margin-top: -10px;
        background-color: #f0f4c3;
    }
    .sellerdetails span{
        font-weight: bold;
        font-style: italic;
        margin-left: 10px;
    }
    </style>
</body>
</html>
