package pl.ndt.manager.components;

import org.springframework.stereotype.Component;

import pl.ndt.manager.model.enums.Objects;

@Component
public class AlertComponent {

	/**
	 * Prints message "Save Successfully"
	 * 
	 * @param object
	 *            Saved object
	 * @return message
	 */
	public String savedSucesfully(Objects object) {
		return object.getValue() + " was saved successfully";
	}

	/**
	 * Prints message "Save Unsuccessfully"
	 * 
	 * @param object
	 *            Saved object
	 * @return message
	 */

	public String savedUnsucesfully(Objects object) {
		return "Something was wrong. " + object.getValue() + " wasn't saved successfully";
	}

	/**
	 * Prints message "Updated Successfully"
	 * 
	 * @param object
	 *            Saved object
	 * @return message
	 */
	public String updateSucesfully(Objects object) {
		return object.getValue() + " was updated successfully";
	}

	/**
	 * Prints message "Save Unsuccessfully"
	 * 
	 * @param object
	 *            Saved object
	 * @return message
	 */
	public String updatedUnsucesfully(Objects object) {
		return "Something was wrong. " + object.getValue() + " wasn't updated successfully";
	}

	/**
	 * Prints message "Deleted Successfully"
	 * 
	 * @param object
	 *            Deleted object;
	 * @return message
	 */
	public String deleteSucesfully(Objects object) {
		return object.getValue() + " was deleted successfully";
	}

	/**
	 * Prints message "Deleted Unsuccessfully"
	 * 
	 * @param object
	 *            Deleted object;
	 * @return message
	 */
	public String deleteUnsucesfully(Objects object) {
		return object.getValue() + " wasn't deleted successfully";
	}

	/**
	 * Prints message "Exist"
	 * 
	 * @param object
	 *            Deleted object;
	 * @return message
	 */
	public String exist(Objects object) {
		return object.getValue() + " already exist. Change email address";
	}
}
