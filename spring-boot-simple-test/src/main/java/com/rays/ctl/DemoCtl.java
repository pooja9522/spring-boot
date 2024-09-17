package com.rays.ctl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.DemoResponse;

@RestController
@RequestMapping(value = "Demo")
public class DemoCtl {

	@GetMapping
	public DemoResponse test() {

		DemoResponse res = new DemoResponse();

		res.setData("pooja jawariya");

		res.setTest("i am a very strong");

		return res;
	}
}