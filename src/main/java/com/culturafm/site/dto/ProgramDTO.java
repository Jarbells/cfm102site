package com.culturafm.site.dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.culturafm.site.entities.Program;

public class ProgramDTO {

	private Long id;
	private String name;
	private String presenter;
	private String daysOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;
	
    private List<String> imageUrls = new ArrayList<>();
	
	public ProgramDTO() {
	}
	
	public ProgramDTO(Program entity) {
		BeanUtils.copyProperties(entity, this);
        // Lógica para converter o Set<ProgramImage> em uma List<String>
        if (entity.getImages() != null) {
            this.imageUrls = entity.getImages().stream()
                                  .map(image -> image.getImageUrl())
                                  .toList();
        }
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPresenter() {
		return presenter;
	}

	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}

	public String getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(String daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
    public List<String> getImageUrls() {
        return imageUrls;
    }
    
    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
