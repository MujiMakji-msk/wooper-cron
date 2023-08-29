package com.wn.wooper.scheduler;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wn.wooper.mapper.RcsResultTableMapper;
import com.wn.wooper.mapper.SejongResultTableMapper;

@Component
public class SAMange {

	private Logger log = LoggerFactory.getLogger(SAMange.class);
	
	@Autowired
	private SejongResultTableMapper sejongResultTableMapper;
	@Autowired
	private RcsResultTableMapper rcsResultTableMapper;
	
	@Scheduled( fixedDelay = 1000 * 60 * 30 )
	private void healthCheck() {
		log.info("cron alive!!!");
	}
	
	// 초 - 분 - 시 - 일 - 월 - 요일
	//@Scheduled( fixedDelay = 1000 * 10 )
	@Scheduled( cron = "0 10 2 25 * *" )
	private void createMessageResultTable() {
		
		String yearMonth = null;
		
		try {
	        
			// 매월 25일 2시 10분 세종Agent 결과 테이블을 생성한다.
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MONTH, 1);
            SimpleDateFormat format = new SimpleDateFormat("YYYYMM");
            yearMonth = format.format(calendar.getTime());

            sejongResultTableMapper.sejongCreateMessageResult(yearMonth);
            
            log.info("Created sejong_msg_result_{} table.", yearMonth);
            
		} catch ( Exception e ) {
			log.error(e.toString() );
		}

	}
	
	//@Scheduled( fixedDelay = 1000 * 10 )
	@Scheduled( cron = "0 20 2 25 * *" )
	private void RcsCreateMessageResultTable() {
		
		String yearMonth = null;
		
		try {
	        
			// 매월 25일 2시 20분 RCS 결과 테이블을 생성한다.
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MONTH, 1);
            SimpleDateFormat format = new SimpleDateFormat("YYYYMM");
            yearMonth = format.format(calendar.getTime());

            rcsResultTableMapper.rcsCreateMessageResult(yearMonth);
            
            log.info("Created RCS_RESULT_{} table.", yearMonth);
            
		} catch ( Exception e ) {
			log.error(e.toString() );
		}

	}
}
