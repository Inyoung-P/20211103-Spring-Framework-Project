/**
 * @author 김재은
 * @date 2021-11-2 ~ 
 * @name 도서 관련 비동기 기능
 */
var bookService = (function() { 

	/** 도서 등록 */
	function bookregister(book, callback) {
		$.ajax({
		    type : "post",
			url : "/book/register",
			data : JSON.stringify(book),
			contentType : "application/json; charset=utf-8",
            success : function(result) {
                if(callback)
                callback(result);
            }
		})
	}
	/** 도서 리스트 조회 */
	function getList(param, callback, error){
	       console.log("book.getList()");
	       var page = param.page || 1;
	     
	        //var url = "/book/pages/" + page;
	        var amount = param.amount || 10;
	        var lastRno = param.lastRno || 0;
	        var url = "/book/pages/" + page+ "/" + amount;
	       $.getJSON(url,function(data) {//$.getJSON:json 파일을 읽어서 웹페이지에 적용
	        //callback(data);//댓글 목록만 가져오는 경우
	    	   if(callback){
	    	   callback(data.totalCnt,data.list);//댓글 숫자와 목록을 가져오는 경우
	       }
	      }).fail(function(xhr,status,err) {
			if(error){
				error();
			}
		});
	}
	/* function getList(param, callback, error){
	       console.log("book.getList()");
	       var amount = param.amount || 10;
	       var lastBno = param.lastRno || 1;
	       var url = '/book/pages/' + lastBno + "/" + amount;
	       $.getJSON(url,function(data) {//$.getJSON:json 파일을 읽어서 웹페이지에 적용
	        callback(data);
	      });
	 }*/
	
    return {
    	bookregister:bookregister,
    	getList:getList
    }
})();