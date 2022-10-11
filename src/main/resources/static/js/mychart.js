let chartDataStr= decodeHtml(chartData);
console.log(chartData);

console.log(JSON.parse(chartDataStr));
let jsonData=JSON.parse(chartDataStr);
const labels=[];
for (let key in jsonData){
    console.log(jsonData[key]['label']);
    labels.push(jsonData[key]['label'])
}

new Chart(document.getElementById("projects"),{
    type:'pie',
    data:{
        labels:labels,
        datasets:[{
            label:"Project Stage",
            backgroundColor:["red","yellow","green"],
            data:jsonData
        }]
    },
    options:{
        title:{
            display:true,
            text:"Project Status"
        }
    }
});



function decodeHtml(html){
    let txt= document.createElement('textarea')
    txt.innerHTML=html;
    return txt.value;
}
