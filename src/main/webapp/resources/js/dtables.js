/**
 * Created by rdas on 12/09/2016.
 * http://www.cscc.edu/_resources/app-data/datatables/examples/server_side/post.html
 * https://www.sitepoint.com/working-jquery-datatables/
 */
$(document).ready(function () {
    console.log("In dtables js.");

    $("#example").dataTable();


    $("#example1").dataTable({
        bFilter: false,
        bInfo: false,
        bJQueryUI: true,
        bPaginate: false,
        bStateSave: false,
        bSort: false,
        "aaData":[
            ["Sitepoint","http://sitepoint.com","Blog","2013-10-15 10:30:00"],
            ["Flippa","http://flippa.com","Marketplace","null"],
            ["99designs","http://99designs.com","Marketplace","null"],
            ["Learnable","http://learnable.com","Online courses","null"],
            ["Rubysource","http://rubysource.com","Blog","2013-01-10 12:00:00"]
        ],
        "aoColumnDefs":[{
            "sTitle":"Site name"
            , "aTargets": [ "site_name" ]
        },{
            "aTargets": [ 1 ]
            , "bSortable": false
            , "mRender": function ( url, type, full )  {
                return  '<a href="'+url+'">' + url + '</a>';
            }
        },{
            "aTargets":[ 3 ]
            , "sType": "date"
            , "mRender": function(date, type, full) {
                return (full[2] == "Blog")
                    ? new Date(date).toDateString()
                    : "N/A" ;
            }
        }]
    });

    $('#example').on('click', 'tr', function(){
        var oData = oTable.fnGetData(this);
        console.log(oData);
    })
});