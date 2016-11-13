$.post("getAllProduct.action",null,function(data){
            data.
        var tr ="<tr><td width='500' item='radio'>选择</td> <td width='500' item='spmc' >1</td><td width='300' item='xh'>2</td><td width='300' item='spbm'>3</td><td width='300' item='dw'></td><td width='300' item='shulv'></td></tr>" ;
        alert(tr);
           $.each(data, function(i,product) {
             $("#product_table").append(tr);
             $.each(product, function(index,field) {
                     alert(filed[0].value);
                   });
           });
        
    });