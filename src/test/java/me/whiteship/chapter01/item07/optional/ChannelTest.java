package me.whiteship.chapter01.item07.optional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ChannelTest {

    @Test
    void npe() {
        Channel channel = new Channel();
        Optional<MemberShip> memberShipOptional = channel.defaultMemberShip();
        memberShipOptional.ifPresent(MemberShip::hello);
    }
}