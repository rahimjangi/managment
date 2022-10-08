new Chart(document.getElementById("projects"),{
    type:'pie',
    data:{
        labels:["NOTSTARTED","INPROGRESS","FINISHED"],
        datasets:[{
            label:"Project Stage",
            backgroundColor:["red","yellow","green"],
            data:[1,10,20]
        }]
    },
    options:{}
});

new Chart(document.getElementById("employees"),{
    type:'pie',
    data:{
        labels:["NOTSTARTED","INPROGRESS","FINISHED"],
        datasets:[{
            label:"Project Stage",
            backgroundColor:["red","yellow","green"],
            data:[1,10,20]
        }]
    },
    options:{}
});