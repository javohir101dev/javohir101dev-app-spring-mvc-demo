<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transfer</title>
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<h1>Kartadan kartaga pul o'tkazish</h1>

<label for="senderCard">Yuboruvchi kartangizni tanlang:</label>
<select name="senderCard" id="senderCard">
    <c:forEach items="${cards}" var="card">
        <option id="card${card.id}" value="${card.id}">${card.number}</option>
    </c:forEach>
</select>

<br/>

<label for="senderAmount">O'tkazmoqchi bo'lgan summangizni kiriting:</label>
<input type="number" id="senderAmount">
<input type="hidden" id="userId" value="${userId}">

<br/>

<label for="receiverCard">Qabul qiluvchi kartangizni tanlang:</label>
<select name="receiverCard" id="receiverCard">
    <c:forEach items="${cards}" var="card">
        <option id="card${card.id}" value="${card.id}">${card.number}</option>
    </c:forEach>
</select>

<button type="button" id="saveTransfer">OK</button>

<script src="../../resources/js/popper.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>
<script src="../../resources/js/jQuery.min.js"></script>


<script>

    $('#saveTransfer').click(function () {
        let senderCard = document.getElementById("senderCard");
        let senderCardId = senderCard.options[senderCard.selectedIndex].value;

        let receiverCard = document.getElementById("receiverCard");
        let receiverCardId = receiverCard.options[receiverCard.selectedIndex].value;

        let amount = document.getElementById("senderAmount").value;
        let userId = document.getElementById("userId").value;

        $.ajax({
            url: "/transfer/save",
            type: "post",
            contentType: 'application/json',
            data: JSON.stringify({
                senderId: senderCardId,
                receiverId: receiverCardId,
                amount: amount
            }),
            success: function (object) {
                // console.log(object);
                if ("OK" === object.status) {
                    alert("Transaction is successfully!")
                    location.href = '/card/' + userId + '/list';
                } else {
                    alert(object.status);
                    alert(object.errorMessage);
                    location.reload();
                }
            },
            error: function (e) {
                console.log(e);
            }
        })
    });

</script>

</body>
</html>
