<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Answer</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1 class="mt-4">Question and Answer</h1>
    <hr>
    <div class="row">
        <div class="col-md-12">
            <h3>Question</h3>
            <p>${question}</p>
        </div> 
    </div>
    <div class="row">
        <div class="col-md-12">
            <h3>Answer</h3>
            <p>${answer}</p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <a href="/" class="btn btn-primary">Ask another question</a>
        </div>
    </div>
</div>

</body>
</html>
