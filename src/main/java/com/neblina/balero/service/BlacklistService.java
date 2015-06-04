package com.neblina.balero.service;

import com.neblina.balero.domain.Blacklist;
import com.neblina.balero.service.repository.BlacklistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlacklistService {

    private final Logger log = LoggerFactory.getLogger(BlacklistService.class);

    @Autowired
    private BlacklistRepository blacklistRepository;

    public void addIpToBlacklist(String ip) {
        log.debug("Adding user to blacklist...");
        try {
            Blacklist blacklist = blacklistRepository.findOneByIp(ip);
            if(blacklist == null) {
                throw new Exception();
            }
            blacklist.setAttemps(blacklist.getAttemps()+1);
            log.debug("Attemps: " + blacklist.getAttemps());
            if(blacklist.getAttemps() > 7) {
                blacklist.setTimer(15 * 60);
            }
            blacklistRepository.save(blacklist);
        } catch (Exception e) {
            Blacklist blacklist = new Blacklist();
            blacklist.setIp(ip);
            blacklist.setAttemps(1);
            blacklist.setTimer(0);
            blacklistRepository.save(blacklist);
        }
    }

    public void deleteUserFromBlacklist(String ip) {
        log.debug("Deleting Banned IP...");
        Blacklist blacklist = blacklistRepository.findOneByIp(ip);
        blacklist.setIp(ip);
        blacklistRepository.delete(blacklist);
    }

    public void updateTimer(String ip) {
        log.debug("Updating timer to IP's List...");
        Blacklist blacklist = blacklistRepository.findOneByIp(ip);
        try {
            if(blacklist.getIp() == null) {
                throw new Exception("User Is Not On The Blacklist. Nothing To Do.");
            }
            if(blacklist.getTimer() <= 0) {
                deleteUserFromBlacklist(ip);
            }
            if(blacklist.getTimer() > 0) {
                blacklist.setTimer(blacklist.getTimer()-60);
                log.debug(blacklist.getTimer() + " Remaining...");
                blacklistRepository.save(blacklist);
            }
        } catch (Exception e) {
            log.debug("Error: " + e.getMessage());
        }
    }

    public List<Blacklist> getAllIps() {
        List<Blacklist> ips = blacklistRepository.findAll();
        return ips;
    }

}
