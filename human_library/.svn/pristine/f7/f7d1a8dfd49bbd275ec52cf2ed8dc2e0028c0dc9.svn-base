/**
 * reply.js
 * 댓글 구현. 클로저를 이용한 모듈
 */
 console.log("reply module")

var replyService = (function(){ 
  function add(reply, callback, error) {//add start
      console.log("reply.add()");

      $.ajax({ //ajax start
        type : "post", //post방식으로 값 보낼거다
        //url는 데이터를 받아올 페이지
        url : "/replies/new", //replies(ReplyController의 매핑주소)에 있는 new(create매핑주소)를 불러옴
        //data는 요청시에 함께 보낼 파라미터들
        data : JSON.stringify(reply),// JSON.stringify():JavaScript 값이나 객체를 JSON 문자열로 변환해서 data에 넣음
        contentType : "application/json; charset=utf-8",
        success : function(data) {//success는 성공시에 수행할 핸들러를 받는다.
          if(callback)
          callback(data);//데이터 성공하면 success를 콜백해줌
        },
        error : function(xhr, stat, er) {
          if(error) {
            error(er);//틀리면 에러띄움
          }
        }
      })//ajax end
  }//add end

   //getList()는 param이라는 객체를 통해서 필요한 파라미터를 전달받아 JSON목록을 호출
   function getList(param, callback, error){
       console.log("reply.getList()");
       var bno = param.bno;//고정값
       var page = param.page || 1;
     
      // var url = '/replies/' + param.bno + "/" + param.amount + "/" + param.lastRno;
        var url = "/replies/pages/" + bno + "/" + page;
        
       $.getJSON(url,function(data) {//$.getJSON:json 파일을 읽어서 웹페이지에 적용
        //callback(data);//댓글 목록만 가져오는 경우
    	   if(callback){
    	   callback(data.replyCnt,data.list);//댓글 숫자와 목록을 가져오는 경우
       }
      }).fail(function(xhr,status,err) {
		if(error){
			error();
		}
	});
}

   function remove(rno,callback,error){
        console.log("reply.remove()");
        console.log(rno);
        //replies(ReplyController의 매핑주소)에 있는 new(create매핑주소)를 불러옴
        var url='/replies/'+rno; 
        $.ajax(url,{
        	//type은 delete rest방식??
            type : "delete" 
          }).done(function(data){
            if(callback)
              callback(data);
         
          })
   }
   function modify(reply,callback,error){
        console.log("reply.modify()");
        var url='/replies/'+reply.rno; 

        $.ajax(url,{
            type : "put", //수정
            url : "/replies/new",//replies(ReplyController의 매핑주소)에 있는 new(create매핑주소)를 불러옴
            data : JSON.stringify(reply),//요청시에 reply를 json형태로 바꿔서 data를 보냄
            contentType : "application/json; charset=utf-8",
            success : function(data) {
                if(callback)
              callback(data);
            }
          })
   }
   function get(rno,callback,error){
        console.log("reply.get()");
        var url='/replies/'+rno; 
        $.getJSON(url,function(data) {
            if(callback)
            callback(data);
          });
   }
 
   function displayTime(timeValue) {
    return moment().diff(moment(timeValue), 'days') < 1 ? moment(timeValue).format('yyyy.MM.DD. HH:mm:ss') : moment(timeValue).format('yyyy.MM.DD. HH:mm:ss');
  }



   return {
     add:add,
     getList:getList,
     remove:remove,
     modify:modify,
     get:get,
     displayTime:displayTime
   }
  })();