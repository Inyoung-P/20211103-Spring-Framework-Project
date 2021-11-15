/**
 * @author 박인영
 * @date 2021-10-29 ~ 2021-11-10
 * @name 대출 관련 기능
 */
var loansService = (function() { 
	
	/** 대출 예약 by Member */
	function reserveLoans(loans, callback, error) {
		$.ajax({
		    type : "post",
			url : "/loans/reserveLoans",
			data : JSON.stringify(loans),
			contentType : "application/json; charset=utf-8",
            success : function(result) {
                if(callback)
                callback(result);
            },
            error : function(xhr, stat, er) {
                if(error) {
                    error(er);
                }
            }
		})		
	}
	
	/** 대출 예약 확정 by Manager */
	function acceptLoans(loans, callback, error) {
		$.ajax({
		    type : "post",
			url : "/loans/acceptLoans",
			data : JSON.stringify(loans),
			contentType : "application/json; charset=utf-8",
            success : function(result) {
                if(callback)
                callback(result);
            },
            error : function(xhr, stat, er) {
                if(error) {
                    error(er);
                }
            }
		})		
	}
	 
	/** 대출 예약 취소 by Manager */
	function cancelLoansReservationByManager(loans, callback, error) {
		$.ajax({
		    type : "post",
			url : "/loans/cancelLoansReservationByManager",
			data : JSON.stringify(loans),
			contentType : "application/json; charset=utf-8",
            success : function(result) {
                if(callback)
                callback(result);
            },
            error : function(xhr, stat, er) {
                if(error) {
                    error(er);
                }
            }
		})		
	}	
	
	/** 대출 완료 by manager */
	function completeLoans(loans, callback, error) {
		$.ajax({
		    type : "post",
			url : "/loans/completeLoans",
			data : JSON.stringify(loans),
			contentType : "application/json; charset=utf-8",
            success : function(result) {
                if(callback)
                callback(result);
            },
            error : function(xhr, stat, er) {
                if(error) {
                    error(er);
                }
            }
		})
	}

	/** 도서 반납 by Manager */
	function returnLoans(loans, callback, error) {
		$.ajax({
		    type : "post",
			url : "/loans/returnLoans",
			data : JSON.stringify(loans),
			contentType : "application/json; charset=utf-8",
            success : function(result) {
                if(callback)
                callback(result);
            }
		})
	}
	
	/** 도서 영구미반납 by Manager */
	function notReturnLoans(loans, callback, error) {
		$.ajax({
		    type : "post",
			url : "/loans/notReturnLoans",
			data : JSON.stringify(loans),
			contentType : "application/json; charset=utf-8",
            success : function(result) {
                if(callback)
                callback(result);
            },
            error : function(xhr, stat, er) {
                if(error) {
                    error(er);
                }
            }
		})
	}
	
	/** 대출 예약 취소 by Member */
	function cancelLoansReservationByMember(loans, callback, error) {
		$.ajax({
		    type : "post",
			url : "/loans/cancelLoansReservationByMember",
			data : JSON.stringify(loans),
			contentType : "application/json; charset=utf-8",
            success : function(result) {
                if(callback)
                callback(result);
            },
            error : function(xhr, stat, er) {
                if(error) {
                    error(er);
                }
            }
		})		
	}
	
	/** 소장 도서 정보(possession) 1건 조회 */
	function possessionDetail(bkno, callback, error){
		$.getJSON("/possession/detail?bkno=" + bkno, function(data) {
            if(callback)
                callback(data);
		}).fail(function(xhr,status,err) {
			if(error){
				error();
			}
		});
	}

    return {
    	reserveLoans:reserveLoans,
    	acceptLoans:acceptLoans,
    	cancelLoansReservationByManager:cancelLoansReservationByManager,
    	completeLoans:completeLoans,
    	returnLoans:returnLoans,
    	notReturnLoans:notReturnLoans,
    	cancelLoansReservationByMember:cancelLoansReservationByMember,
    	possessionDetail:possessionDetail
    }
    
})();