var courses=['maincourse','dessert','appetizer','beverage'];
let flag=0;

function itemSearch(){
    let input=document.getElementById("searchMenu").value.toLowerCase();
    let filter=input.toUpperCase();
    if(courses.includes(input)){
        let menu=document.getElementById(input);
        for(let i=0;i<menu.childElementCount;i++){
            menu.children[i].style.display="";
        }
    }
    else {
    let items=document.getElementsByClassName('item');
    for(let i=0;i<items.length;i++){
        let itemName=items[i].innerHTML;
        if(itemName.toUpperCase().indexOf(filter)>-1)
        {
            items[i].style.display="block";
        }
        else{
            items[i].style.display="none";
        }
    }
    }
}

function tableSearch(){
    let input=document.getElementById("searchTable").value;
    let filter=input.toUpperCase();
    let tables=document.getElementsByClassName("table");
    for(let i=0;i<tables.length;i++){
        let tableName=tables[i].children[0].innerHTML;
        if(tableName.toUpperCase().indexOf(filter)>-1){
            tables[i].style.display="block";
        }
        else{
            tables[i].style.display="none";
        }
    }
}

function dragstart_handler(ev){
    console.log("drag-start");
    ev.dataTransfer.setData("text",ev.target.id);
    console.log(ev);
   
}

function dragover_handler(ev){
    console.log('drag-over');
    ev.preventDefault();
}

function drop_handler(ev,target){
    console.log('drop');
    ev.preventDefault();
    const data=ev.dataTransfer.getData("text");
    console.log(target.id); 
    let tableId=target.id;
    let item=document.getElementById(data).textContent.split(" Rs-");
    let itemTableId="order"+tableId.slice(5,6);
    var itemExists=false;
    let quantity=1;
    let tableRow=document.getElementById(itemTableId).getElementsByTagName("tbody");
    console.log(tableRow.length);
    for(var i=0;i<tableRow.length;i++){
        let tr=tableRow[i].children[0];
        let itemname=tr.children[0].textContent;
        if(itemname==item[0]){
            itemExists=true;
            alert(item[0]+" has been already ordered at "+target.id.toUpperCase());
            break;
        } 
    }
    let quantityId=tableId.slice(5,6)+"q"+document.getElementById(itemTableId).rows.length;
    let itemTable=document.getElementById(itemTableId);
    if(itemExists==false){
        itemTable.innerHTML+=`<tr><td>${item[0]}</td><td>${item[1]}</td><td><input type='number' style="background:transparent; " id='${quantityId}' value="${quantity}" min="1" max="8" onchange="setQuantity(this); calculateTotalByQuantity('${itemTableId}','${tableId}')"></td><td><textarea id='suggestionBox' style="background:transparent;" rows='2' cols='8'></textarea></td><td><button style="background:transparent;" class="deleteButton" onclick="deleteItem(this,'${itemTableId}','${tableId}')"><i class="fa fa-trash"></i></button></td></tr> `
    }
    let numberOfItems=document.getElementById(itemTableId).rows.length-1;
    document.getElementById(tableId).children[2].innerHTML=`Total Items: ${numberOfItems}`
    calculateTotalByQuantity(itemTableId,tableId);
    
}

function calculateTotalByQuantity(itemTableId,tableId){
    let ans=0;
    let tableRows=document.getElementById(itemTableId).rows;
    for(let i=1;i<tableRows.length;i++){
        let quantityId=tableRows[i].children[2].children[0].id;
        let price=parseInt(tableRows[i].children[1].textContent);
        ans+=price*parseInt(document.getElementById(quantityId).value);
        console.log(quantityId);
        console.log(ans);
    }
    document.getElementById(tableId).children[1].innerHTML=`Rs : ${ans}`
    document.getElementById(tableId).children[2].innerHTML=`Total Items : ${tableRows.length-1}`
}

function deleteItem(ele,itemTableId,tableId){
    ele.parentElement.parentElement.parentElement.remove();
    calculateTotalByQuantity(itemTableId,tableId);
}

function setQuantity(e){
    let quantity=e.value;
    e.defaultValue=quantity;
}

function viewDetails(id){
    let priceCheck=document.getElementById(id).parentElement.children[1].textContent;
    console.log(priceCheck);
    if(flag==1){
        console.log("empty");
        close(id);
    }
    else if(priceCheck=="Rs : 0")
    {
        console.log("empty");
        close(id);
    }
    else{
    let itemTable=document.getElementById(id);
    let bill="bill"+id.slice(5,6);
    document.getElementById(bill).style.display='';
    itemTable.style.display='block';
    console.log(itemTable);
    }
    flag=0;
}

function close(id){
    let itemTable=document.getElementById(id);
    let bill="bill"+id.slice(5,6);
    document.getElementById(bill).style.display='none';
    itemTable.style.display='none';
}

function generateBill(id){
    flag=1;
    let itemTable=document.getElementById(id);
    console.log(itemTable);
    let tableId='table'+id.slice(5,6);
    let payable=document.getElementById(tableId).children[1].innerHTML;
    itemTable.innerHTML=`<thead><tr>
    <th>Item</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Suggestions</th>
    </tr></thead>`
    calculateTotalByQuantity(id,tableId);
    let bill="bill"+id.slice(5,6);
    alert("Amount to Pay at "+tableId.toUpperCase()+" - "+payable);
    close(id);
}