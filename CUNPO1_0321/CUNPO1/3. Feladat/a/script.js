function init()
{
    const canvas = document.getElementById('BTCanvas');
    const context = canvas.getContext("2d");
    
    context.font = "18px Arial";
    context.fillStyle = "orange";
    context.textAlign = "center";
    context.fillText("Programtervező informatikus 2024", canvas.width / 2, 20);

    drawSemiCircle(context);
    drawRectangle(context);
    drawGradient(context);
    drawImg(context);

    context.imageSmoothingEnabled = false;
}

function drawSemiCircle(context)
{
    context.beginPath();
    context.arc(200, 65, 30, 45, 10.8, false);
    context.closePath();
    context.lineWidth = 0.8;
    context.fillStyle = 'yellow';
    context.fill();
    context.strokeStyle = '#0000FF';
    context.stroke();
}

function drawRectangle(context)
{
    context.beginPath();
    context.rect(30, 85, 75, 40);
    context.stroke();
}

function drawGradient(context)
{
    const centerX = 40 + 55 / 2;
    const centerY = 30 + 30 / 2;
    
    const grd = context.createRadialGradient(
        centerX, centerY, 0.05,
        centerX, centerY, 30
    );

    grd.addColorStop(0.2, "yellow");
    grd.addColorStop(0.4, "red");
    grd.addColorStop(0.7, "blue");
    grd.addColorStop(0.8, "#39ff14");

    context.fillStyle = grd;
    
    context.fillRect(40, 30, 55, 30);
}

function drawImg(context)
{
    const img = new Image();

    img.src = 'the.png';

    img.onload = function()
    {
        context.drawImage(img, 220, 110, 80, 40);
    };
}