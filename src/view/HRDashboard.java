package view;

import model.Employee;
import model.UserRole;
import util.PositionRoleMapper;

import javax.swing.*;
import java.awt.*;

/**
 * HR Dashboard for HR personnel
 * Extends the existing HRDashboard from ui package
 */
public class HRDashboard extends ui.HRDashboard {
    
    public HRDashboard(Employee user) {
        super(user);
        
        // Add HR-specific customizations
        customizeForHRRole(user);
    }
    
    private void customizeForHRRole(Employee user) {
        UserRole role = PositionRoleMapper.getUserRole(user.getPosition());
        
        // Update title to reflect HR role
        setTitle("MotorPH HR Management System - " + user.getFullName() + " (" + role.getDisplayName() + ")");
        
        // Add HR-specific status information
        SwingUtilities.invokeLater(() -> {
            // Find and update status components if needed
            updateHRSpecificFeatures(role);
        });
    }
    
    private void updateHRSpecificFeatures(UserRole role) {
        // Add role-specific features based on HR level
        switch (role) {
            case HR_MANAGER:
                // Full HR access
                break;
            case HR_SPECIALIST:
                // Limited HR access
                break;
            case HR_ASSISTANT:
                // Basic HR access
                break;
        }
    }
}