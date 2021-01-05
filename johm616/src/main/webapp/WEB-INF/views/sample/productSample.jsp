<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="/crewmate/core" prefix="core"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<title>ojt</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="shortcut icon" href="/images/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="/css/jquery-ui-1.12.1.min.css">
<link rel="stylesheet" href="/css/bo/common.css" type="text/css">
<link rel="stylesheet" href="/css/bo/theme_typeA.css" type="text/css">
<link rel="stylesheet" href="/css/bo/icons/font-awesome.css"
	type="text/css">



<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/jquery-ui-1.12.1.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<tiles:insertDefinition name="boCommonScript" />
<script type="text/javascript" src="/js/form.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script>
jQuery(function($) {
	$(document).ready(function(){
		// 저장
		$(".modifyProduct").on('click', function() {
			insertProductForm();
		});
		
    // 관련 상품
    var cntrPrdtUseYn = 'false';
    if(cntrPrdtUseYn == 'true'){
        $('div#cntrPrdtList').show();
    }else{
        $('div#cntrPrdtList').hide();
    }
    
    $('.cntrPrdtUseYn').click(function(){
        var cntrPrdtUseYn = $(this).val();
        if(cntrPrdtUseYn == 'true'){
            $('div#cntrPrdtList').show();
        }else{
            $('div#cntrPrdtList').hide();
        }
    });
    
    var update = 'ADD' == 'MOD';
    if (update) {
        loadListAdminMemo('productMemoArea', '');
        // 상품키워드리스트 문자열로 변환
        //<input type="text" name="srchWord" style="width:60%;" value="" maxlength="255" onkeydown="modifyEnter();"/>
        var list = new Array();
        
        $("input[name=srchWord]").val(list.join(","));
        if (false) {
            $(".toggleUseOptnArea").toggle();
            optnItemReadOnly();
        }
    }
	 
    $("input[name='optnName']").val("사이즈");
	    	
    // 정보고시 function
		$("select[name='prntFtcInfoSeq']").change(function() {
			getFtcInformationForPrdtCode($(this).val());
		});
	
    getFtcInformationForPrdtCode($("select[name='prntFtcInfoSeq']").val());
	
		function getFtcInformationForPrdtCode(ftcInfoSeq) {
			/* if(ftcInfoSeq == "") {
				$("#ftcInfoList").html("");
			} 
			else { */
					var value = Number($('select[name="prntFtcInfoSeq"]').val());
		    	$.ajax({
		           	type: "post"
		          	,url: "/product/getFtcInformationForPrdtCode"
	          		, data: {'prntFtcInfoSeq' : value}
                , dataType: "json"
		           	,success : function(html) {		           		
		           		if(html.infoMap == null) {
			        			return false;
			        		} else {
			        			$("select[name='prntFtcInfoSeq']").on("change", function() {
			           				$(this).nextAll().remove();                				
			        			});                			
				            var $tab_content = $('#ftcInfoList')[0];
				            var content = "<table>";
												content += "<colgroup>";
												content += "<col width='20%' />";
												content += "<col width='*' />";
												content += "</colgroup>";				                    
								    $.each(html.infoMap.list, function(index, item){
										  	content += "<tr>";
												content += "<th>" + item.ftcInfoName + "</th>";
												content += "<td>";
												content += "<textarea name='infoNotcConts' style='width:60%' ></textarea>";
												content += "<input type='checkbox' class='dispYns' id='dispYns" + index +"' /> <label for='dispYns0'>해당없음</label>";
												content += "<input type='hidden' name='ftcInfoSeqs' value='" + item.ftcInfoSeq + "'/>";
												content += "<input type='hidden' name='dispYns' value='false'/>";
												content += "</td>";
												content += "</tr>";
										})
												content += "</table>";
										$tab_content.append($(content)[0]);
			        		}
		           		$("#ftcInfoList").html(content);
		           	}
		        });
			//}		
		}				
		// 옵션 사용 여부 function
		var CountOption = $(".optionMasterTables").length;
		$(".selectOptnUseYn").on("change",function(event){
				$(".toggleUseOptnArea").toggle();
				if($(this).val()=="false"){
					$("#optnMasterArea").empty();
					$("#optnSelectArea").empty();
				}
				$(".addOptnStock").show();
				$(".respectOptnStock").hide();
				CountOption = 0;
		});
	
		$(".btnAddOptionMaster").click(function() {
			 ++CountOption;
			 var content = "<table id=\"tableOptionMaster"+ CountOption + "\" class=\"group-center mt30 optionMasterTables\" keyindex=\""+CountOption+"\">";
			 content += "<colgroup>";
			 content += "<col width=\"20%\">";
			 content += "<col width=\"*\">";
			 content += "<col width=\"30%\">";
			 content += "<col width=\"20%\">";
			 content += "</colgroup>";
			 content += "<tbody>";
			 content += "<tr>";
			 content += "<td colspan=\"4\" class=\"align-left\">";
			 content += "<div class=\"fl-l\">";
			 content += "<input type=\"hidden\" name=\"optnMstrOrderKeys\" value=\"" + CountOption + "\">";
			 content += "<input type=\"hidden\" name=\"optnMstrIds\" value=\"" + CountOption + "\">";
			 content += "&nbsp;순서<i class=\"entypo-check\"></i>: <input type=\"text\" name=\"optnMstrOrders\" value=\"" + CountOption + "\"maxlength=\"3\" class=\"inputNumberText optnReadOnly\" style=\"width:15%\">";
			 content += "&nbsp;옵션분류명<i class=\"entypo-check\"></i>: <input type=\"text\" name=\"optnMstrNames\" maxlength=\"15\" style=\"width:35%\" value=\"\" class=\"optnReadOnly\">";
			 content += "</div>";
			 content += "<div class=\"fl-r\">";
			 content += "<a href=\"#행추가\" class=\"btn btn-sm btn-blue btnAddOptionDetail btnInvisible\" tableid=\"tableOptionMaster" + CountOption + "\">행추가<i class=\"entypo-list-add\"></i></a>";
			 content += "<a href=\"#삭제\" class=\"btn btn-sm btn-danger btnDeleteOptionMaster btnInvisible\" tableid=\"tableOptionMaster" + CountOption + "\">삭제</a>";
			 content += "</div>";
			 content += "</td>";
			 content += "</tr>";
			 content += "<tr>";
			 content += "<th>옵션ID<i class=\"entypo-check\"></i></th>";
			 content += "<th>옵션명<i class=\"entypo-check\"></i></th>";
			 content += "<th>추가금액(원)<i class=\"entypo-check\"></i></th>";
			 content += "<th>삭제</th>";
			 content += "</tr>";
			 content += "<tr>";
			 content += "<td><input type=\"hidden\" name=\"optnDetailMstrOrders\" value=\""+CountOption+"\">";
			 content += "<input type=\"text\" name=\"optnDetailIds\" maxlength=\"3\" value=\"01\" style=\"width:90%\" class=\"optnReadOnly\"></td>";
			 content += "<td><input type=\"text\" name=\"optnDetailValues\" maxlength=\"15\" value=\"\" style=\"width:90%\" class=\"optnReadOnly\"></td>";
			 content += "<td><input type=\"text\" name=\"optnDetailAmts\" maxlength=\"6\" value=\"0\" style=\"width:90%\" class=\"inputNumberText optnReadOnly\"></td>";
			 content += "<td><a href=\"#삭제\" class=\"btn btn-sm btn-danger btnDeleteOptionDetail btnInvisible\">삭제</a></td>";
			 content += "</tr>";
			 content += "</tbody></table>";
			 
			 $("#optionMasterArea").append(content);
		});
		var optionDetailLength = $(".optionMasterTables >tbody tr").length-2;
		$(document).on("click", "a.btnAddOptionDetail", function() {
		    var content = '';
		    var tableId = $(this).attr("tableId");
		    content += '<tr>';
		    content += '<td><input type="hidden" name="optnDetailMstrOrders" value="' + $("#" + tableId).attr("keyIndex") + '"><input type="text" name="optnDetailIds" value="" style="width:90%" class="optnReadOnly"></td>';
		    content += '<td><input type="text" name="optnDetailValues" value="" style="width:90%" class="optnReadOnly"></td>';
		    content += '<td><input type="text" name="optnDetailAmts" value="0" style="width:90%" class="inputNumberText optnReadOnly"></td>';
		    content += '<td><a href="#삭제" class="btn btn-sm btn-danger btnDeleteOptionDetail btnInvisible">삭제</a></td>';
		    content += '</tr>';
		    $("#" + tableId).append(content);
		});
		$(document).on("click", "a.btnDeleteOptionMaster", function() {
			if(confirm("옵션을 삭제하시겠습니까?")) {
				  CountOption--;
					$(this).parents(".optionMasterTables").remove();
			}
		});
		
		$(document).on("click", "a.btnDeleteOptionDetail", function() {
			$(this).parent().parent().remove();
		});
		
		// 옵션재고추가 버튼
		$(".addOptionStockSelect").click(function() {
			
			if (CountOption === 0) {
					alert('옵션는(은) 생략할 수 없습니다.');
					return false;
			}
			let check = false;
			let html = "";
			let optnMstrName = $('input[name=optnMstrNames]');
			var optnMstrOrders = $('input[name=optnMstrOrders]');
			
			$('#optionSelectArea').empty();
			
			html += '<table id="tableOptionSelecter" class="group-center mt30 optionMasterTables">';
			html += '<tbody><tr>';
			html += '<td class="align-left">';
			html += '<p id="optionFailure" class="mb10 bold fc-01">다음과 같은 오류가 발생하였습니다. 확인해주세요.</p>';
			console.log(optnMstrName.eq(i).val());
			for(var i = 0; i < optnMstrName.length; i++) {
				if(optnMstrName.eq(i).val() <= 0) {
					html += '<p class="mb5">옵션분류명은 생략할 수 없음['+optnMstrOrders.eq(i).val()+']</p>';
					check = true;
				}
				if(optnMstrOrders.eq(i).val().length <= 0) {
					html += '<p class="mb5">옵션순서는 생략할 수 없음</p>';
					check = true;
				}
				for(var j = i+1; j < optnMstrOrders.length; j++) {
					if(optnMstrOrders.eq(i).val() === optnMstrOrders.eq(j).val()) {
						html += '<p class="mb5">옵션순서가 중복되었습니다.['+optnMstrOrders.eq(i).val()+']</p>';
						check = true;
					}
				}
			}
			for(var i = 0 ; i< CountOption; i++){
				let optnValues = $('#optionMasterArea').find('table').eq(i).find('input[name=optnDetailValues]');
				for(let j =0; j< optnValues.length; j++){
					if(optnValues.eq(j).val().length <= 0){
						html += '<p class="mb5">옵션명을 입력해주세요['+optnMstrOrders.eq(i).val()+']['+optnMstrName.eq(i).val()+']['+optnValues.eq(j).val()+']</p>';
						check = true;
					}
				}
				let optnDetailIds = $('#optionMasterArea').find('table').eq(i).find('input[name=optnDetailIds]');
				for(var h = 0; h <optnDetailIds.length; h++){
					for(let j = h+1 ; j<optnDetailIds.length; j++){
						if(optnDetailIds.eq(h).val() === optnDetailIds.eq(j).val()){
							html += '<p class="mb5">옵션 상세ID가 중복되었습니다.['+optnMstrOrders.eq(i).val()+']['+optnMstrName.eq(i).val()+']['+optnDetailIds.eq(i).val()+']['+optnValues.eq(i).val()+']</p>';
							check = true;
						}	
					}	
				}
				
				for(var j = 0;j< optnDetailIds.length; j++){
					if(optnDetailIds.eq(j).val().length <=0){
						html += '<p class="mb5">옵션ID을 입력해주세요['+optnMstrOrders.eq(i).val()+']['+optnMstrName.eq(i).val()+']['+optnDetailIds.eq(j).val()+']</p>';
						check = true;
					}
					if(optnDetailIds.eq(j).val().length <=0){
						
					}
				}
				let optnDetailAmts = $('#optionMasterArea').find('table').eq(i).find('input[name=optnDetailAmts]');
				for(var j = 0;j< optnDetailAmts.length; j++){
					if(optnDetailAmts.eq(j).val().length <=0){
						html += '<p class="mb5">추가금액을 입력해주세요['+optnMstrOrders.eq(i).val()+']['+optnMstrName.eq(i).val()+']['+optnDetailAmts.eq(j).val()+']</p>';
						check = true;
					}
				}
			}
			html += '</td>';
			html += '</tr>';
			html += '</tbody>';
			html += '</table>';
			
			if(check){
				$('#optionSelectArea').append(html);
				html="";
				return false;
			} 
			
			/* var value = "value";
			var optnMstrOrdersSort = optnMstrOrders.sort(function(a,b){
				 return a[value] - b[value];
			} )
			$.each(optnMstrOrdersSort, function(index, item){
				item.closest('table')
			}); */
			var optn = {
					optnMstrOrderKeysArray : [],
					optnMstrNamesArray : [], 
					optionIdArray : [],
					optionNameArray : [],
					optionPriceArray : []
			}
	 		var count = 1;
	 		for(var i = 0; i < $("table.optionMasterTables").length; i++) {
					    				    			
	 			var optnMstrOrderKeys = [];
	 			var optnMstrNames = [];
	 			var optionId = [];
	 			var optionName = [];
	 			var optionPrice = [];
	 			
 				// optnMstrOrders
 				optnMstrOrderKeys.push($("table.optionMasterTables").eq(i).find("tr").eq(0).find("input")[0].value);
 				// optnMstrNames
 				optnMstrNames.push($("table.optionMasterTables").eq(i).find("tr").eq(0).find("input")[3].value); 

	 			for(var j = 2; j < $("table.optionMasterTables").eq(i).find("tr").length; j++) {	    						 				
	 				// optionId
	 				optionId.push($("table.optionMasterTables").eq(i).find("tr").eq(j).find("input")[1].value);
	 				// optionName
	 				optionName.push($("table.optionMasterTables").eq(i).find("tr").eq(j).find("input")[2].value);
	 				count = count*optionName.length;
	 				// optionPrice
	 				optionPrice.push($("table.optionMasterTables").eq(i).find("tr").eq(j).find("input")[3].value);
	
	 			}
	 			optn.optnMstrOrderKeysArray.push(optnMstrOrderKeys);
	 			optn.optnMstrNamesArray.push(optnMstrNames);
	 			optn.optionIdArray.push(optionId);
	 			optn.optionNameArray.push(optionName);
	 			optn.optionPriceArray.push(optionPrice);
	 		};

			// 배열 조합하기
			var list = new Array();
			var temp = new Array();
			for (var i = 0; i < optn.optnMstrOrderKeysArray.length; i++) {
			    temp = new Array();
			    if(i == 0) {
			        for (var j = 0; j < optn.optionIdArray[i].length; j++) {
			            temp.push(optn.optnMstrNamesArray[i] + ":" + optn.optionNameArray[i][j]);
			        }
			    } else if(i > 0) {
			        for(var j = 0; j < list.length; j++) {
			            for (var k = 0; k < optn.optionIdArray[i].length; k++) {
			                temp.push(list[j]+", " + optn.optnMstrNamesArray[i] + ":" + optn.optionNameArray[i][k]);              
			            }
			        }   
			    }
			    list = temp;
			};
			
			// value 조합하기
			var value = new Array();
			var temp = new Array();
			for(var i = 0; i < optn.optnMstrOrderKeysArray.length; i++) {
			    temp = new Array();
			    if(i == 0) {
			        for(var j = 0; j < optn.optionIdArray[i].length; j++) {
			            temp.push("00" + optn.optnMstrOrderKeysArray[i] + ":" + optn.optionIdArray[i][j]);
			        } 
			    } else if(i > 0) {
			        for(var j = 0; j < value.length; j++) {
			            for(var k = 0; k < optn.optionIdArray[i].length; k++) {
			                temp.push(value[j] + "-" + "00" +optn.optnMstrOrderKeysArray[i] + ":" + optn.optionIdArray[i][k]);
			            }
			        }
			    }
			    value = temp;
			};
			
			// price 조합하기
			var price = new Array();
			var temp = new Array();
			for(var i = 0; i < optn.optnMstrOrderKeysArray.length; i++) {
			    temp = new Array();
			    if(i == 0) {
			        for(var j = 0; j < optn.optionIdArray[i].length; j++) {
			            temp.push(parseInt(optn.optionPriceArray[i][j]));
			        } 
			    } else if(i > 0) {
			        for(var j = 0; j < price.length; j++) {
			            for(var k = 0; k < optn.optionIdArray[i].length; k++) {
			                temp.push(parseInt(price[j]) + parseInt(optn.optionPriceArray[i][k]));
			            }
			        }
			    }
			    price = temp;
			};
			
 			var content = "<table id='tableOptionSelecter' class='group-center mt30 optionMasterTables'>";
          content += "<colgroup>";
          content += "<col width='10%'>";
          content += "<col width='*'>";
          content += "<col width='18%'>";
          content += "<col width='18%'>";
          content += "<col width='15%'>";
          content += "<col width='15%'>";
          content += "</colgroup>";
          content += "<tbody><tr>";
          content += "<th>사용여부</th>";
          content += "<th>옵션명</th>";
          content += "<th>판매금액</th>";
          content += "<th>추가금액</th>";
          content += "<th>재고<i class='entypo-check'></i></th>";
          content += "<th>전시여부</th>";
          content += "</tr>";
          
					for(var i = 0; i < list.length; i++) {
			     	    content += "<tr>";
			          content += "<td><input type='checkbox' name='selectStockIndex' value='" + i + "'></td>";
			          content += "<td>";
		    	 			content += list[i];          	        
			          content += "<input type='hidden' name='stockIndex' value='" + i + "'>";
			          content += "<input type='hidden' name='selectedOptnDtlIds' value='" + value[i] + "'>";
			          content += "<input type='hidden' name='stockSeqs' value='0'>";
			          content += "</td>";
			          content += "<td class='align-right'><span class='_dscntSellPrice'></span> 원</td>";     
			          content += "<td class='align-right'>" + price[i] +  " 원</td>";
			          content += "<td><input type='text' name='selectedStockCounts' value='0' style='width:80%' class='inputNumberText'></td>";
		            content += "<td><select name='selectedOptnDispYns'>";
		            content += "<option value='true' selected=''>예</option>";
		            content += "<option value='false'>아니오</option>";
		            content += "</select>";
		            content += "</td>";
		            content += "</tr>";
				  }
					
           content += "</tbody>";
           content += "</table>";
    				$("#addOptionSelectArea").html(content);
    				
          $(".optnReadOnly").attr("readonly", true);
          $(".btnInvisible").hide();
          $(".respectOptionStockSelect").show();
          $(".addOptionStockSelect").hide();

	        
		      $(".respectOptionStockSelect").click(function() {
		      	optnItemClearReadOnly();
		      });

			    function optnItemReadOnly() {
			        $(".respectOptionStockSelect").show();
			        $(".addOptionStockSelect").hide();
			        $(".optnReadOnly").attr("readonly", "readonly");
			        $(".btnInvisible").hide();
			    }
			    
			    function optnItemClearReadOnly() {
			        $(".respectOptionStockSelect").hide();
			        $(".addOptionStockSelect").show();
			        $(".optnReadOnly").removeAttr("readonly");
			        $(".btnInvisible").show();
			        $("#addOptionSelectArea").html("");
			    }
			});
		});	
});

function validateCheck(){
	// 업체 체크
	if ($("select[name='vndrCntrtId']").val() == ''){
        alert("업체를 선택해주세요.");
        $("input[name='vndrCntrtId']").focus();
        return false;
  }
	// 영문 상품명 체크
	if ($("input[name='prdtEngName']").val() == '') {
				alert("영문상품명을 입력해주세요.");
				$("input[name='prdtEngName']").focus();
				return false;
	}
	// 국문 상품명 체크
	if ($("input[name='prdtKorName']").val() == '') {
				alert("국문상품명을 입력해주세요.");
				$("input[name='prdtKorName']").focus();
				return false;
	}
	// 브랜드 조회 체크
	if ($("#brandName").val() == '') {
				alert("브랜드를 조회해주세요.");
				$("#brandName").focus();
				return false;
	}
	// 원산지 조회 체크
	if ($("select[name='cooCode']").val() == '') {
				alert("원산지를 조회해주세요.");
				$("select[name='cooCode']").focus();
				return false;
	}
	// 제조사 조회 체크
	if($("input[name='mnftrName']").val() == ''){
         alert("제조사는 입력하셔야 합니다.");
         $("input[name='mnftrName']").focus();
      
         return false;
  }
	// 상단,하단 아이콘 설정
	var upIcon = $("input:checkbox[name='upIconCode']:checked").length;
	var lowIcon = $("input:checkbox[name='downIconCode']:checked").length;
	if((upIcon > 0) || (lowIcon > 0)){
     if(parseInt(upIcon + lowIcon) > 2){
        alert('아이콘은 2개만 가능합니다.');
         $("input:checkbox[name='upIconCode']").focus();
      
         return false;
     }
  }
	// 상품 분류 체크
  if($("input[name='ctgrIds']").length == 0){
     alert("상품분류는 1개 이상이어야 합니다.");
     $("select[name='selectCategorys']").focus();
  
     return false;
  }else{
     if($("input[name='stdCtrgYnId']:checked").length == 0){
        alert("기준상품분류가 있어야 합니다.");
        $("input[name='stdCtrgYnId']").focus();
     
        return false;
     }
  }
	// 정상가 체크
  if($("input[name='prdtSellPrice']").val() == ''){
     alert("정상가는 입력하셔야 합니다.");
     $("input[name='prdtSellPrice']").focus();
  
     return false;
  }
	// 판매가 체크
	if($("input[name='dscntErpSellPrice']").val() == ''){
	   alert("판매가는 입력하셔야 합니다.");
	   $("input[name='dscntErpSellPrice']").focus();
	
	   return false;
	}
	// 최소구매수량 체크
  if($("input[name='minBuyCount']").val() == ''){
     alert("최소구매수량은 입력하셔야 합니다.");
     $("input[name='minBuyCount']").focus();
  
     return false;
  }
	// 최대구매수량 체크
  if($("input[name='maxBuyCount']").val() == '') {
     alert("최대구매수량은 입력하셔야 합니다.");
     $("input[name='maxBuyCount']").focus();
  
     return false;
  }
	// 관련상품 설정 체크
  if ($("input[name='cntrPrdtUseYn']").val() == 'true'){
      if($("a.btnCntrPrdtDelete").length == 0){
         alert("관련상품정보 있음 상태에서 추가정보가 없습니다.");
         $("input[name='cntrPrdtUseYn']").val().focus();
      
         return false;
      }
  }
 	// 이미지 체크
 	if($("#prdtImagePath01").val() == ''){
     alert("메인이미지는 필수 입니다.");
     $("#prdtImagePath01").focus();
     return false;
  }
 	// 재고수량 체크
  if ('false' == $("select[name='optnUseYn']").val() || 'false' == $("input[name='optnUseYn']").val()) {
    if ($("input[name='noOptionStockCount']").val() == '') { 
    	alert("재고수량은 생략할 수 없습니다.");
    	$("input[name='noOptionStockCount']").focus();
    	return false;
    }
  } else {
   if ($("input:checkbox[name='selectStockIndex']:checked").length == 0) {
	   alert("최소 하나의 옵션은 생성하여 재고를 등록/선택 하여야 합니다.");
	   return false;
   }
  }
 	
 	// 정보고시
 	$(".dispYns").on("click", function() {
		if($(this).is(":checked")) {
			$(this).parent().find("textarea[name='infoNotcConts']").val("해당없음").attr("readonly", "readonly");
		}
		else {
			$(this).parent().find("textarea[name='infoNotcConts']").val("").removeAttr("readonly");
		}
	});


  var errorMessage = ''; 
  $("input[name='optnDetailAmts']").each(function() {
    if ($(this).val() == '') {
    	$(this).val(0);
    }
  });
  
  $("input[name='optnDetailValues']").each(function() {
       if ($(this).val() == '') {
           $(this).focus();
           errorMessage = "옵션명는(은) 생략할 수 없습니다.";
       }
  });

  $("input[name='optnDetailIds']").each(function() {
       if ($(this).val() == '') {
           $(this).focus();
           errorMessage = "옵션아이디는(은) 생략할 수 없습니다.";
       }
  });
  
  if (!(errorMessage == '')) {
    alert(errorMessage);
    return false;
  }

 return true;
}

//할인율 계산
function chngErpSellPriceRate() {
    let sellPrice = $('input[name="prdtSellPrice"]').val();
    let erpSellPrice = $('input[name="dscntErpSellPrice"]').val();

    if (sellPrice==="undifiend" || sellPrice===""){
       sellPrice = 0;
    }
    if (erpSellPrice === "undifiend" || erpSellPrice === ""){
       erpSellPrice = 0;
    }
    let result = discountRate(parseInt(sellPrice), parseInt(erpSellPrice));
 
    $('input[name="erpSellPriceRate"]').val(parseInt(result));
 
    return false;
 }
 
function discountRate(sellPrice, dscntSellPrice){

    var newDiscountRate = ((parseInt(sellPrice) - parseInt(dscntSellPrice)) / (parseInt(sellPrice) * 1.0)) * 100.0;
    newDiscountRate = Math.ceil(newDiscountRate);
    
    return newDiscountRate;
}

function imageError(obj) {
    obj.src = "//image.crewmate.co.kr/demoshop/noimage.gif";
}
//브랜드 팝업창 호출 function
function openBrandPopup(multiYn) {
    if (multiYn == undefined || multiYn == "" || multiYn != "Y") {
        multiYn = "N";
    }
    window.open("/product/brandList/popup?callback=callbackBrandPopup&decorator=adminPopup&multiYn=" + multiYn, 'popupBrandList','width=1024 ,height=768 ,scrollbars=yes,resizable=yes');
    return false;
}
//브랜드 팝업창 callback function
function callbackBrandPopup(brandName, brandId){
    $('#brandName').val(brandName);
    $('#brandId').val(brandId);
}


$("span#listProductSelectCategory").each(function () {
    categorySelectLoad("00", 0, $(this).attr("id"), "selectCategorys");
});

function categorySelectLoad(prntCtgrId, maxLength, divId, inputName) {
    if (prntCtgrId == undefined || prntCtgrId == "") {
        prntCtgrId = "00";
    }

    if (maxLength == undefined || maxLength == "") {
        maxLength = 0;
    }

    if (divId == undefined || divId == '') {
        divId = "categorySelect";
    }

    if (inputName == undefined || inputName == '') {
        inputName = 'selectCategory';
    }

    var params = "prntCtgrId=" + prntCtgrId;
    params += "&maxLength=" + maxLength;
    params += "&divId=" + divId;
    params += "&inputName=" + inputName;

    $.ajax({
        type: "GET"
        , url: "/product/listCategoryForSelect"
        , data: encodeURI(params)
        , dataType: "json"
        , success: function (html) {
        		if(html.infoMap == null) {
        			return false;
        		} else {
        			$("select[name='selectCategorys']").on("change", function() {
           				$(this).nextAll().remove();                				
        			});                			
	            var $tab_content = $('.align-left>#listProductSelectCategory')[0];
	            var content = '<select name="selectCategorys" onchange="categorySelectLoad(this.value, ' + '0' +', ' + 'listProductSelectCategory' + ', ' + 'selectCategorys' + ');">'								                    
	            		content	+='<option value="00">---- 선택 ----</option>'
					    $.each(html.infoMap.list, function(index, item){
							  	content += '<option value="'+item.ctgrId+'">'+item.ctgrName+'</option>';
							})
									        + '</select>';
							$tab_content.append($(content)[0]);
        		}
        }
    });
}
//category 추가 
function addCategory() {               
	var addCategory = $('select[name=selectCategorys] option:selected');
	var addCategoryValue= addCategory[addCategory.length-1].value;
	var content = "";
	for(var i = 0; i < addCategory.length; i++) {
			content += '>' + addCategory[i].text;
	}
	if($('select[name=selectCategorys] option:selected') == null){
        alert('카테고리를 선택하세요.');
    } else {
        if($('input[name="ctgrIds"]').filter('input[value="' + addCategoryValue + '"]').length != 0) {
            alert('이미선택한 카테고리 입니다.');
        } else {
            var html = '<tr><td><input type="radio" name="stdCtrgYnId" value="' + addCategoryValue + '"/></td><td class="align-left">\n';
            html += content + '<input type="hidden" name="ctgrIds" value="' + addCategoryValue + '"/>\n';
            html += '</td><td><a href="javascript://" class="btn  btn-sm btn-danger prdtCategoryDelBtn" id="remove">삭제</a></td></tr>\n';
            
            $('table.prdtCtgrList').append(html);
        }
    }
};        
// category 삭제
$(document).on("click", "a.prdtCategoryDelBtn", function(){
  var btnLength = $('a.prdtCategoryDelBtn').length;

  if(btnLength == 1){
     alert("최소 하나의 상품분류는 등록되어 있어야 합니다.");
     return false;
  }
  if(confirm("삭제하시겠습니까?")){
       $(this).unbind('click');
       $(this).parent().parent().remove();
  }
});
 
// 관련상품 팝업창 호출 function
function productListPopup(callbackFn) {
    var win = window.open('/product/productPopupList/popup?callback=callbackProductListPopup&decorator=adminPopup&multiYn=' + callbackFn, 'product', 'width=1400px, height=800px, resizable=no, location=no, top=100px, left=300px;');
    if(typeof(callbackFn) == "function"){
        win.callbackFn = callbackFn;
        win.onload = function(){
            win.callbackFn = callbackFn;
        }
    }
}
//관련상품 팝업창 callback function
function callbackProductListPopup(multiYn, data){
	if(multiYn == "Y"){
		var html = "";
	 	var index = 1;
	  for(var i=0; i<data.list.length; i++){
		  if(('' != data.list[i].prdtCode) && ($('input[name="cntrPrdtCodes"]').filter('input[value="' + data.list[i].prdtCode + '"]').length == 0)){
	      html += '<tr><td>' + index++;
	      html += '</td><td>' + data.list[i].prdtCode + '<input type="hidden" value="'+ data.list[i].prdtCode +'" name="cntrPrdtCodes"/>';
	      html += '</td><td class="align-left">' + data.list[i].prdtEngName + '</td><td>' + data.list[i].brandName + '</td><td>';
	      html += data.list[i].category + '</td><td>' + '<a href="javascript://" class="btn btn-sm btn-danger btnCntrPrdtDelete" id="remove">삭제</a>' + '</td></tr>';
		  }
	  }
	  $('table#tableCntrPrdtList').append(html);
	} else{
		if(data.list.prdtCode == ''){
				alert('동일한 상품은 선택할수 없습니다.');
				return;
		}
		if($('input[name="cntrPrdtCodes"]').filter('input[value="' + data.list.prdtCode + '"]').length != 0) {
				alert('이미선택한 상품 입니다.');
				return;
		}
		var html = '<tr><td>' + $('table#tableCntrPrdtList tr').length;
					html += '</td><td>' + data.list.prdtCode + '<input type="hidden" value="' + data.list.prdtCode+'" name="cntrPrdtCodes"/>';
					html += '</td><td>' + data.list.prdtEngName + '</td><td>' + data.list.brandName + '</td><td>';
					html += data.list.ctgrPath + '</td><td>' + '<a href="javascript://" class="btn btn-sm btn-danger btnCntrPrdtDelete" id="remove">삭제</a>' + '</td></tr>';
					
		$('table#tableCntrPrdtList').append(html);
	}
}

function openFile(fileId){
	$('#' + fileId).click();
}

function clearImg(obj){
    if(obj == 1){
       $("#prdtImagePath").attr("src", "");
       $("#prdtImagePath1").attr("src", "");
       $("#prdtImagePath01").val("");
    }else{
        $("#prdtImagePath" + obj).attr("src", "");
        $("#prdtImagePath0" + obj).val("");
    }
     return false;
}

function displayFile(obj, imageId) {
	 if (obj.files && obj.files[0]) {

	 		$('#' + imageId).val(obj.value);

	 		var reader = new FileReader();
	  
	  	reader.onload = function (e) {
		  		switch(imageId){
		        case 'prdtImagePath01' :
		            $('#prdtImagePath').attr('src', e.target.result);
		            $('#prdtImagePath1').attr('src', e.target.result);
		            break;
		        case 'prdtImagePath02' :
		            $('#prdtImagePath2').attr('src', e.target.result);
		            break;
		        case 'prdtImagePath03' :
		            $('#prdtImagePath3').attr('src', e.target.result);
		            break;
		        case 'prdtImagePath04' :
		            $('#prdtImagePath4').attr('src', e.target.result);
		            break;
		        case 'prdtImagePath05' :
		            $('#prdtImagePath5').attr('src', e.target.result);
		            break;
		        case 'prdtImagePath06' :
		            $('#prdtImagePath6').attr('src', e.target.result);
		            break;
		        case 'prdtImagePath07' :
		            $('#prdtImagePath7').attr('src', e.target.result);
		            break;
		        default:
		           alert('이미지업로드시 오류가 발생했습니다.');
		    	}
	  	}
	  	reader.readAsDataURL(obj.files[0]);
	 }
}

function insertProductForm() {
	if(validateCheck()){
		if (!confirm("상품정보를 저장하시겠습니까?")) {
		    return false; 
		}

		$("textarea[name='prdtDtlInfo']").val(CKEDITOR.instances.prdtDtlInfo.getData());
		$(".expsrYns").each(function() {
		  $(this).parent().find("input[name='dispYns']").val(!$(this).is(":checked")); 
		});    
		
		
		$("form#modifyProductForm").ajaxSubmit({
			url: "/product/insertProduct"
			, dataType: "json"
			, type : "post"
			, processData: false
			, contentType: false
			, success: function(data) {
					if(data.resultCode == 1 ) {
						alert("저장되었습니다.");
						//document.location.reload();
					} else {
						alert('저장실패 하였습니다. 상단에 오류메시지를 확인하세요');
		         var errorMessages = data.errorMessages;
		         $("div#errorMessagesArea").html("");
		         for (var i = 0; i < errorMessages.length; i++) {
		             $('div#errorMessagesArea').append('<strong style="color:red">' + errorMessages[i] + '</strong>' + '<br/>');
		         }
		         document.location.href = "#";
					}
			}
			, error: function(xhr, status, error) {
		       alert("시스템 오류가 발생 했습니다. 관리자에게 문의하세요.");
		   }
		});
	}
};


</script>
</head>

<body style="padding-top: 0px;">
	<div class="wrap">


		<div class="header-wrap"></div>
		<div class="container-wrap">
			<div class="container" style="padding-bottom: 7%;">
				<article class="contents">
					<header class="contents-header">
						<h3 class="heading-title">
							<i class="awesome-large awesome-file"></i> 상품등록
						</h3>
						<ol class="location">
							<li><a href=""> <i class="entypo-home">Home</i>
							</a></li>
							<li><i class="entypo-right-open-mini">상품관리</i></li>
							<li><i class="entypo-right-open-mini">상품관리</i></li>
							<li class="active"><i class="entypo-right-open-mini"></i> <strong>상품등록</strong>
							</li>
						</ol>
					</header>
					<section class="contents-inner">
						<form id="modifyProductForm" name="modifyProductForm"
							action=${popupYn eq 'Y' ? "/product/product/popup" : "/product/product"}
							method="post" enctype="multipart/form-data">
							<div id="errorMessagesArea"></div>
							<div class="form-group table">
								<div class="grid-box">
									<div class="fl-l">
										<h5>
											<i class="entypo-plus-squared"></i> 상품 기본정보
										</h5>
									</div>
									<div class="fl-r mb5">
										<a href="javascript://" class="btn btn-primary modifyProduct"
											id="create">저장</a>
									</div>
								</div>
								<table>
									<colgroup>
										<col width="15%">
										<col width="*">
										<col width="13%">
										<col width="37%">
									</colgroup>
									<tbody>
										<tr>
											<th>업체 <i class="entypo-check"></i>
											</th>
											<td colspan="3"><select name="vndrCntrtId"
												id="idVnderCntrtId">
													<option value>선택해주세요</option>
													<c:forEach var="vendor" items="${vendorList}">
														<option value="${vendor.vndrCntrtId}"><c:out
																value="${vendor.vndrName}"></c:out>(수수료:${vendor.vndrCmsnRate}%)
														</option>
													</c:forEach>
											</select></td>
										</tr>
										<tr>
											<th>영문/국문상품명 <i class="entypo-check"></i>
											</th>
											<td colspan="3"><input type="text" name="prdtEngName"
												style="width: 35%;" value="" maxlength="50">
												&nbsp;/&nbsp; <input type="text" name="prdtKorName"
												style="width: 35%;" value="" maxlength="50"></td>
										</tr>
										<tr>
											<th>상품코드</th>
											<td><span class="bold fc-01">[자동생성]</span> <input
												type="hidden" name="prdtCode" value></td>
											<th>브랜드 <i class="entypo-check"></i>
											</th>
											<td><input type="text" id="brandName" name="brandName"
												style="width: 100px;" value readonly="readonly"> <input
												type="hidden" id="brandId" name="brandId"
												style="width: 150px;" value> <a href="javascript://"
												class="btn btn-blue btn-search" onclick="openBrandPopup();">
													<i class="entypo-search"></i>
											</a></td>
										</tr>
										<tr>
											<th>원산지<i class="entypo-check"></i></th>
											<td><select name="cooCode" class="select_class">
													<option value="">선택해 주세요</option>
													<c:forEach var="origin" items="${originList}">
														<option value="${origin.codeName}"><c:out
																value="${origin.codeValue}"></c:out></option>
													</c:forEach>

											</select></td>
											<th>판매여부</th>
											<td><input type="radio" name="prdtStatCode" value="P"
												checked="checked" id="prdtStatCode1"><label
												for="prdtStatCode1">판매중&nbsp;</label> <input type="radio"
												name="prdtStatCode" value="S" id="prdtStatCode2"><label
												for="prdtStatCode2">일시품절&nbsp;</label> <input type="radio"
												name="prdtStatCode" value="F" id="prdtStatCode3"><label
												for="prdtStatCode3">판매중지&nbsp;</label></td>
										</tr>
										<tr>
											<th>제조사<i class="entypo-check"></i></th>
											<td><input type="text" name="mnftrName"
												style="width: 150px;" value="" maxlength="40"></td>
											<th>전시여부</th>
											<td><input type="radio" name="dispYn" value="true"
												checked="checked" id="dispYn1"><label for="dispYn1">전시&nbsp;</label>
												<input type="radio" name="dispYn" value="false" id="dispYn2"><label
												for="dispYn2">미전시&nbsp;</label></td>
										</tr>
										<tr>
											<th>상단아이콘설정</th>
											<td colspan="3"><input type="checkbox" name="upIconCode"
												value="01" id="upIconCode1"><label for="upIconCode1">신상품&nbsp;</label>
												<input type="checkbox" name="upIconCode" value="02"
												id="upIconCode2"><label for="upIconCode2">추천상품&nbsp;</label>
												<input type="checkbox" name="upIconCode" value="03"
												id="upIconCode3"><label for="upIconCode3">인기상품&nbsp;</label>
												<input type="checkbox" name="upIconCode" value="04"
												id="upIconCode4"><label for="upIconCode4">베스트상품&nbsp;</label>
												<input type="checkbox" name="upIconCode" value="05"
												id="upIconCode5"><label for="upIconCode5">HIT&nbsp;</label>
												<input type="checkbox" name="upIconCode" value="06"
												id="upIconCode6"><label for="upIconCode6">NEW&nbsp;</label>
											</td>
										</tr>
										<tr>
											<th>하단아이콘설정</th>
											<td colspan="3"><input type="checkbox"
												name="downIconCode" value="07" id="downIconCode1"><label
												for="downIconCode1">세일&nbsp;</label> <input type="checkbox"
												name="downIconCode" value="08" id="downIconCode2"><label
												for="downIconCode2">단독&nbsp;</label> <input type="checkbox"
												name="downIconCode" value="09" id="downIconCode3"><label
												for="downIconCode3">이벤트&nbsp;</label> <input type="checkbox"
												name="downIconCode" value="10" id="downIconCode4"><label
												for="downIconCode4">기획&nbsp;</label></td>
										</tr>
										<tr>
											<th>키워드설정</th>
											<td colspan="3"><input type="text" name="srchWord"
												style="width: 60%;" value="" maxlength="255"> ※키워드를
												쉼표(,)로 구분하여 주세요.</td>
										</tr>
									</tbody>
								</table>
							</div>

							<!-- 상품 분류정보 -->
							<div class="form-group table mt30">
								<h5 class="mb5">
									<i class="entypo-plus-squared"></i> 상품 분류정보
								</h5>
								<table class="prdtCtgrList group-center">
									<colgroup>
										<col width="12%">
										<col width="*">
										<col width="8%">
									</colgroup>
									<tbody>
										<tr>
											<td colspan="3" class="align-left"><span
												id="listProductSelectCategory"> <select
													name="selectCategorys"
													onchange="categorySelectLoad(this.value, '0', 'listProductSelectCategory', 'selectCategorys');">
														<option value="00">---- 선택 ----</option>
														<c:forEach var="category" items="${categoryList}"
															varStatus="status">
															<option value="${category.ctgrId}"><c:out
																	value="${category.ctgrName}"></c:out></option>
														</c:forEach>

												</select>
											</span> <span class="btn btn-sm btn-blue prdtCategoryAddBtn"
												onclick="addCategory();"> 추가 <i
													class="entypo-list-add"></i>
											</span></td>
										</tr>
										<tr>
											<th>기준상품분류</th>
											<th>상품분류정보</th>
											<th>삭제</th>
										</tr>
									</tbody>
								</table>
							</div>

							<!-- 상품 가격정보 -->
							<div class="form-group table mt30">
								<h5 class="mb5">
									<i class="entypo-plus-squared"></i>상품 가격정보
								</h5>
								<table>
									<colgroup>
										<col width="15%" />
										<col width="*" />
										<col width="15%" />
										<col width="35%" />
									</colgroup>
									<tr>
										<th>정상가<i class="entypo-check"></i></th>
										<td><input type="text" name="prdtSellPrice" value=""
											style="width: 80%; ime-mode: disabled;" maxlength="8"
											class="inputNumberText" onblur="chngErpSellPriceRate();" />원
										</td>
										<th>판매가<i class="entypo-check"></i></th>
										<td><input type="text" name="dscntErpSellPrice" value=""
											style="width: 57%; ime-mode: disabled;" maxlength="8"
											class="inputNumberText" onblur="chngErpSellPriceRate();" />원
											&nbsp;&nbsp; 할인율 <input type="text" name="erpSellPriceRate"
											style="width: 15%;" value="" readonly="readonly" />%</td>
									</tr>
									<tr>
										<th>최소구매수량<i class="entypo-check"></i></th>
										<td><input type="text" name="minBuyCount" value="1"
											style="width: 35%;" maxlength="5" class="inputNumberText"
											style="ime-mode: disabled;" /></td>
										<th>최대구매수량<i class="entypo-check"></i></th>
										<td><input type="text" name="maxBuyCount" value="99999"
											style="width: 35%;" maxlength="5" class="inputNumberText"
											style="ime-mode: disabled;" /></td>
									</tr>
									<tr>
										<th>배송비구분<i class="entypo-check"></i></th>
										<td colspan="3"><input type="radio" name="freeDlvyYn"
											value="true" id="freeDlvyYn1" /><label for="freeDlvyYn1">무료&nbsp;</label>
											<input type="radio" name="freeDlvyYn" value="false"
											checked="checked" id="freeDlvyYn2" /><label
											for="freeDlvyYn2">유료&nbsp;</label></td>
									</tr>
								</table>
							</div>

							<!-- 상품 옵션정보 -->
							<div class="form-group table mt30">
								<h5 class="mb5">
									<i class="entypo-plus-squared"></i>상품 옵션정보
								</h5>
								<table class="group-center">
									<colgroup>
										<col width="15%" />
										<col width="*" />
										<col width="15%" />
										<col width="35%" />
									</colgroup>
									<tr>
										<th>옵션사용여부 <i class="entypo-check"></i></th>
										<td class="align-left"><select name="optnUseYn"
											class="selectOptnUseYn">
												<option value="true">사용</option>
												<option value="false" selected>사용안함</option>
										</select></td>
										<th><span style="display:;" class="toggleUseOptnArea">옵션
												재고</span><span style="display: none;" class="toggleUseOptnArea">옵션
												분류 추가</span><i class="entypo-check"></i></th>
										<td class="align-left">
											<p style="display:;" class="toggleUseOptnArea">
												<input type="text" name="noOptionStockCount" value="0"
													class="inputNumberText" style="width: 80%">
											</p>
											<p style="display: none;" class="toggleUseOptnArea">
												<a href="#행추가"
													class="btn btn-sm btn-blue btnAddOptionMaster btnInvisible">추가<i
													class="entypo-list-add"></i></a>
											</p>
										</td>
									</tr>
								</table>
							</div>

							<div id="optionMasterArea" class="form-group table"></div>
							<div class="grid-box toggleUseOptnArea" style="display: none">
								<div class="fl-r">
									<a href="#옵션재고추가" class="btn btn-primary addOptionStockSelect">옵션재고추가</a>
									<a href="#옵션재고삭제"
										class="btn btn-danger respectOptionStockSelect"
										style="display: none">옵션재고삭제</a>
								</div>
							</div>
							<div id="addOptionSelectArea" class="form-group table"></div>
							<div id="optionSelectArea" class="form-group table"></div>

							<!-- 관련상품정보 -->
							<div class="form-group table mt30">
								<h5 class="mb5">
									<i class="entypo-plus-squared"></i>관련상품정보
								</h5>
								<table>
									<col width="20%" />
									<col width="*" />
									<tr>
										<th>관련상품정보 설정</th>
										<td><input type="radio" name="cntrPrdtUseYn" value="true"
											class="cntrPrdtUseYn" id="cntrPrdtUseYn1" /> <label
											for="cntrPrdtUseYn1">관련상품있음&nbsp;</label> <input type="radio"
											name="cntrPrdtUseYn" value="false" class="cntrPrdtUseYn"
											checked="checked" id="cntrPrdtUseYn2" /> <label
											for="cntrPrdtUseYn2">관련상품없음&nbsp;</label></td>
									</tr>
								</table>
								<div id="cntrPrdtList">
									<div class="grid-box mb5">
										<div class="fl-r">
											<a href="javascript://" onclick="productListPopup('Y');"
												title="새창에서 열림" class="btn btn-sm btn-blue">관련상품추가<i
												class="entypo-popup"></i></a>
										</div>
									</div>
									<table id="tableCntrPrdtList" class="group-center">
										<colgroup>
											<col width="8%" />
											<col width="15%" />
											<col width="*" />
											<col width="15%" />
											<col width="20%" />
											<col width="8%" />
										</colgroup>
										<tr>
											<th>번호</th>
											<th>상품코드</th>
											<th>상품명</th>
											<th>브랜드</th>
											<th>상품분류</th>
											<th>삭제</th>
										</tr>
									</table>
								</div>
							</div>

							<!-- 정보고시정보 -->
							<div class="form-group table mt30">
								<h5 class="mb5">
									<i class="entypo-plus-squared"></i>정보고시정보
								</h5>
								<p class="mb5">
									<select name="prntFtcInfoSeq">
										<option value="">선택해 주세요</option>
										<c:forEach var="ftcInfo" items="${ftcInfo}">
											<option value="${ftcInfo.ftcInfoSeq}"><c:out
													value="${ftcInfo.ftcInfoName}"></c:out></option>
										</c:forEach>
									</select>
								</p>
								<div id="ftcInfoList"></div>
							</div>

							<!-- 상품 이미지정보 -->
							<div class="form-group table mt30">
								<!-- start image_register -->
								<div class="image_register">
									<h5 class="mb5">
										<i class="entypo-plus-squared"></i>상품 이미지정보
									</h5>
									<table>
										<colgroup>
											<col width="41%" />
											<col width="*" />
										</colgroup>
										<tbody>
											<tr>
												<td>
													<div class="images_view">
														<p class="big_size">
															<img src="" alt="hello" id="prdtImagePath"
																class="lazy-loading" width="250" height="250"
																onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>
														</p>
														<img src="" alt="hello" id="prdtImagePath1"
															class="lazy-loading smallImage" width="50" height="50"
															onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>

														<img src="" alt="hello" id="prdtImagePath2"
															class="lazy-loading smallImage" width="50" height="50"
															onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>

														<img src="" alt="hello" id="prdtImagePath3"
															class="lazy-loading smallImage" width="50" height="50"
															onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>

														<img src="" alt="hello" id="prdtImagePath4"
															class="lazy-loading smallImage" width="50" height="50"
															onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>

														<img src="" alt="hello" id="prdtImagePath5"
															class="lazy-loading smallImage" width="50" height="50"
															onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>

														<img src="" alt="hello" id="prdtImagePath6"
															class="lazy-loading smallImage" width="50" height="50"
															onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>

														<img src="" alt="hello" id="prdtImagePath7"
															class="lazy-loading smallImage" width="50" height="50"
															onerror="imageError(this)" />
														<noscript>
															<img src="//image.crewmate.co.kr" />
														</noscript>
													</div> <!-- end images_view -->
												</td>
												<td class="register">
													<ul>
														<li>최적의 이미지 사이즈는 <span class="fc-01">400 x 400
																pixel</span>입니다.
														</li>
														<li>파일명은 영문/숫자의 조합만 가능합니다.</li>
														<li>JPG 또는 GIF만 등록 가능합니다.</li>
													</ul>
													<ul class="register">

														<li class="first-child mb5"><span class="fc-01">
																필수 </span> 1. 대표이미지 <input type="text" id="prdtImagePath01"
															name="prdtImagePaths" style="width: 55%;" value=""
															class="" /> <input type="hidden" name="prdtImageCodes"
															value="01" /> <input type="file" id="prdtImageFile01"
															name="prdtImageFile01"
															onchange="displayFile(this, 'prdtImagePath01');"
															style="display: none;" /> <a href="javascript://"
															onclick="openFile('prdtImageFile01');"
															class="btn btn-blue btn-icon">찾아보기<i
																class="entypo-popup"></i></a> <a href="javascript://"
															class="btn btn-danger btn-search" onclick="clearImg(1);"><i
																class="entypo-cancel"></i></a></li>
														<li class="first-child mb5"><span class="fc-01">
																선택 </span> 2. 추가이미지 <input type="text" id="prdtImagePath02"
															name="prdtImagePaths" style="width: 55%;" value=""
															class="" /> <input type="hidden" name="prdtImageCodes"
															value="02" /> <input type="file" id="prdtImageFile02"
															name="prdtImageFile02"
															onchange="displayFile(this, 'prdtImagePath02');"
															style="display: none;" /> <a href="javascript://"
															onclick="openFile('prdtImageFile02');"
															class="btn btn-blue btn-icon">찾아보기<i
																class="entypo-popup"></i></a> <a href="javascript://"
															class="btn btn-danger btn-search" onclick="clearImg(2);"><i
																class="entypo-cancel"></i></a></li>
														<li class="first-child mb5"><span class="fc-01">
																선택 </span> 3. 추가이미지 <input type="text" id="prdtImagePath03"
															name="prdtImagePaths" style="width: 55%;" value=""
															class="" /> <input type="hidden" name="prdtImageCodes"
															value="03" /> <input type="file" id="prdtImageFile03"
															name="prdtImageFile03"
															onchange="displayFile(this, 'prdtImagePath03');"
															style="display: none;" /> <a href="javascript://"
															onclick="openFile('prdtImageFile03');"
															class="btn btn-blue btn-icon">찾아보기<i
																class="entypo-popup"></i></a> <a href="javascript://"
															class="btn btn-danger btn-search" onclick="clearImg(3);"><i
																class="entypo-cancel"></i></a></li>
														<li class="first-child mb5"><span class="fc-01">
																선택 </span> 4. 추가이미지 <input type="text" id="prdtImagePath04"
															name="prdtImagePaths" style="width: 55%;" value=""
															class="" /> <input type="hidden" name="prdtImageCodes"
															value="04" /> <input type="file" id="prdtImageFile04"
															name="prdtImageFile04"
															onchange="displayFile(this, 'prdtImagePath04');"
															style="display: none;" /> <a href="javascript://"
															onclick="openFile('prdtImageFile04');"
															class="btn btn-blue btn-icon">찾아보기<i
																class="entypo-popup"></i></a> <a href="javascript://"
															class="btn btn-danger btn-search" onclick="clearImg(4);"><i
																class="entypo-cancel"></i></a></li>
														<li class="first-child mb5"><span class="fc-01">
																선택 </span> 5. 추가이미지 <input type="text" id="prdtImagePath05"
															name="prdtImagePaths" style="width: 55%;" value=""
															class="" /> <input type="hidden" name="prdtImageCodes"
															value="05" /> <input type="file" id="prdtImageFile05"
															name="prdtImageFile05"
															onchange="displayFile(this, 'prdtImagePath05');"
															style="display: none;" /> <a href="javascript://"
															onclick="openFile('prdtImageFile05');"
															class="btn btn-blue btn-icon">찾아보기<i
																class="entypo-popup"></i></a> <a href="javascript://"
															class="btn btn-danger btn-search" onclick="clearImg(5);"><i
																class="entypo-cancel"></i></a></li>
														<li class="first-child mb5"><span class="fc-01">
																선택 </span> 6. 메인이미지 <input type="text" id="prdtImagePath06"
															name="prdtImagePaths" style="width: 55%;" value=""
															class="" /> <input type="hidden" name="prdtImageCodes"
															value="06" /> <input type="file" id="prdtImageFile06"
															name="prdtImageFile06"
															onchange="displayFile(this, 'prdtImagePath06');"
															style="display: none;" /> <a href="javascript://"
															onclick="openFile('prdtImageFile06');"
															class="btn btn-blue btn-icon">찾아보기<i
																class="entypo-popup"></i></a> <a href="javascript://"
															class="btn btn-danger btn-search" onclick="clearImg(6);"><i
																class="entypo-cancel"></i></a></li>
														<li class="first-child mb5"><span class="fc-01">
																선택 </span> 7. 목록이미지 <input type="text" id="prdtImagePath07"
															name="prdtImagePaths" style="width: 55%;" value=""
															class="" /> <input type="hidden" name="prdtImageCodes"
															value="07" /> <input type="file" id="prdtImageFile07"
															name="prdtImageFile07"
															onchange="displayFile(this, 'prdtImagePath07');"
															style="display: none;" /> <a href="javascript://"
															onclick="openFile('prdtImageFile07');"
															class="btn btn-blue btn-icon">찾아보기<i
																class="entypo-popup"></i></a> <a href="javascript://"
															class="btn btn-danger btn-search" onclick="clearImg(7);"><i
																class="entypo-cancel"></i></a></li>
													</ul>
													<p>메인/목록 이미지를 등록하지 않으면 대표이미지가 축소되어 저장됩니다.</p>
													<p>메인이미지의 최적 사이즈는 200 * 200 pixel 입니다.</p>
													<p>목록이미지의 최적 사이즈는 150 * 150 pixel 입니다.</p>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<!-- end image_register -->
							</div>

							<!-- 상품 상세정보 -->
							<div class="form-group table mt30">
								<h5 class="mb5">
									<i class="entypo-plus-squared"></i>상품 상세정보
								</h5>
								텍스트 및 이미지로 제작한 파일을 업로드 해주세요.(동영상은 업로드 불가합니다.)
								<table>
									<tr>
										<td><textarea name="prdtDtlInfo" rows="8" cols="60"></textarea>
											<script type="text/javascript"
												src="/js/ckeditor/ckeditor.js?t=B37D54V"></script> <script
												type="text/javascript">//<![CDATA[
                                                CKEDITOR.replace('prdtDtlInfo', { "filebrowserUploadUrl": "\/admin\/productImageUpload", "height": "500px" });
                                            //]]></script></td>
									</tr>
								</table>
								<div class="grid-box">
									<p class="fl-r">
										<a href="javascript://" class="btn btn-primary modifyProduct"
											id="create">저장</a>
									</p>
								</div>
							</div>
						</form>
					</section>
				</article>
			</div>
		</div>
	</div>
	<div class="footer-wrap">
		<footer class="footer">
			<address>copyright 2016 crewmate all right reserved.</address>
		</footer>
	</div>
</body>
</body>



<!-- <script type="text/javascript" src="/js/crewshop.js"></script>
<script>


//소속 벤더 콜백
function popupCallback(data){
    console.log(data);
    alert('callback');
}

//주소 우편번호 콜백
function completeCallback(addr,zip){
    $('#zipcode').val(zip);
    $('#baseAddr').val(addr);
}

//object to json
function toJson() {
    var htmlArr = [];
    htmlArr.push('============toJson 전===========<br>');
    htmlArr.push('${ctgList}');
    htmlArr.push('<br>');
    htmlArr.push('================================<br><br>');
    htmlArr.push('============toJson 후===========<br>');
    htmlArr.push(${core:toJson(ctgList) });
    htmlArr.push('<br>');
    htmlArr.push('================================<br><br>');
    htmlArr.push('============toJson된 실제 데이터 값===========<br>');
    htmlArr.push('${core:toJson(ctgList) }');
    htmlArr.push('<br>');
    htmlArr.push('================================<br>');
    $('#jsonDiv').html(htmlArr.join());
}

// 브랜드 콜백
function callbackBrand(jsonData) {
    console.log(jsonData);
    console.log(jsonData.brandNm);
}

/**
 * 로딩바 샘플
 * 보통 ajax 통신 전에 로딩바를 노출시킨 후
 * ajax 통신 완료가 끝나면 숨김
 */
function loadingBarTest(){
    // 로딩바 생성
    showLoadingBar();

    // 숨김 테스트를 위하여.. 시간차 줌
    setTimeout(function(){
        hideLoadingBar();
    },500);
}

// 배너 콜백
function callbackBnrPopup(data) {
    var param = decodeURIComponent(data.param);
    var test = "";
    for (var i in data.list) {
        console.log(data.list[i]);
        test += (data.list[i].dispItemSeq + ", " + data.list[i].title + "\n")
    }

    $("#testArea").val("param=" + param + "\n" + test);
    $("#testArea").focus();
}

// 컨텐츠 콜백
function callbackContPopup(data) {
    var param = decodeURIComponent(data.param);
    var test = "";
    for (var i in data.list) {
        console.log(data.list[i]);
        test += (data.list[i].dispItemSeq + ", " + data.list[i].title + "\n")
    }

    $("#testArea").val("param=" + param + "\n" + test);
    $("#testArea").focus();
}

// 전시 영역 콜백
function callbackDispAreaPopup(data) {
    var param = decodeURIComponent(data.param);
    var test = "";
    for (var i in data.list) {
        console.log(data.list[i]);
        test += (data.list[i].dispAreaId + ", " + data.list[i].dispAreaTypeNm + "\n")
    }

    $("#testArea").val("param=" + param + "\n" + test);
    $("#testArea").focus();
}

// 관리자 콜백함수
function callbackAdminPopup(data){
    var param = decodeURIComponent(data.param);
    var test = "";
    for (var i in data.list) {
        console.log(data.list[i]);
        test += (data.list[i].adminId + ", " + data.list[i].adminNm + "\n")
    }

    $("#testArea").val("param=" + param + "\n" + test);
    $("#testArea").focus();
}

// 상품 콜백함수
function callbackPrdPopup(data){
    var test = "";
    for (var i in data.list) {
        console.log(data.list[i]);
        test += (data.list[i].prdMstSeq + ", " + data.list[i].prdNm + "\n")
    }

    $("#testArea").val(test);
    $("#testArea").focus();
}

// sample callback function
function callbackSamplePopup(data) {
    let test = "";
    data.list.forEach((data) => {
        test += (data.boardArtclSeq + ' / ' + data.boardArtclTitle + '\n');
    });
    $("#testArea").val(test);
    $("#testArea").focus();
}
</script> -->
</html>